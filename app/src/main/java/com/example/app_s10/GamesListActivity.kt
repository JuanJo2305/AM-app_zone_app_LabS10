package com.example.app_s10

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class GamesListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var genreDropdown: AutoCompleteTextView
    private lateinit var progressBar: ProgressBar
    private lateinit var allGames: MutableList<Game>
    private lateinit var filteredGames: MutableList<Game>
    private lateinit var gameAdapter: GameAdapter
    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games_list)

        // Inicializar vistas
        recyclerView = findViewById(R.id.recyclerGames)
        progressBar = findViewById(R.id.progressBarGames)
        searchView = findViewById(R.id.searchView)
        genreDropdown = findViewById(R.id.genreDropdown)

        // Inicializar Firebase
        auth = FirebaseAuth.getInstance()
        val userId = auth.currentUser?.uid ?: return
        database = FirebaseDatabase.getInstance().getReference("games").child(userId)

        // Configurar RecyclerView
        allGames = mutableListOf()
        filteredGames = mutableListOf()
        gameAdapter = GameAdapter(
            games = filteredGames,
            onClick = { game -> goToEditGame(game) },
            onLongClick = { game -> confirmDelete(game) }
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = gameAdapter

        setupSearch()

        // Configurar filtro por género
        val genres = listOf("Todos", "Acción", "Aventura", "Deportes", "RPG", "Estrategia")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, genres)
        genreDropdown.setAdapter(adapter)
        genreDropdown.setOnItemClickListener { _, _, _, _ -> applyFilters() }

        // Cargar datos desde Firebase
        fetchGames()
    }

    private fun fetchGames() {
        progressBar.visibility = View.VISIBLE

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                allGames.clear()
                for (child in snapshot.children) {
                    val game = child.getValue(Game::class.java)
                    game?.let { allGames.add(it) }
                }

                // Mostrar todo sin filtros
                filteredGames.clear()
                filteredGames.addAll(allGames)
                gameAdapter.updateGames(filteredGames)

                progressBar.visibility = View.GONE
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("GamesList", "Error al cargar juegos: ${error.message}")
                progressBar.visibility = View.GONE
            }
        })
    }


    private fun setupSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?) = false
            override fun onQueryTextChange(newText: String?): Boolean {
                applyFilters()
                return true
            }
        })
    }


    private fun applyFilters() {
        val query = searchView.query.toString().lowercase()
        val selectedGenre = genreDropdown.text.toString()

        filteredGames.clear()
        filteredGames.addAll(allGames.filter { game ->
            (selectedGenre == "Todos" || game.genre.equals(selectedGenre, ignoreCase = true)) &&
                    game.title.lowercase().contains(query)
        })

        gameAdapter.updateGames(filteredGames)
    }

    private fun confirmDelete(game: Game) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar juego")
            .setMessage("¿Estás seguro de eliminar '${game.title}'?")
            .setPositiveButton("Sí") { _, _ -> deleteGame(game) }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun deleteGame(game: Game) {
        val userId = auth.currentUser?.uid ?: return
        database.child(game.id).removeValue()
            .addOnSuccessListener {
                Toast.makeText(this, "Juego eliminado", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al eliminar", Toast.LENGTH_SHORT).show()
            }
    }

    private fun goToEditGame(game: Game) {
        val intent = Intent(this, EditGameActivity::class.java)
        intent.putExtra("game", game)
        startActivity(intent)
    }

}
