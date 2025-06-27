package com.example.app_s10

import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class EditGameActivity : AppCompatActivity() {

    private lateinit var etTitle: TextInputEditText
    private lateinit var etGenre: TextInputEditText
    private lateinit var ratingBar: RatingBar
    private lateinit var btnUpdate: Button

    private lateinit var game: Game
    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance().reference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_game)

        etTitle = findViewById(R.id.etGameTitleEdit)
        etGenre = findViewById(R.id.etGameGenreEdit)
        ratingBar = findViewById(R.id.ratingBarEdit)
        btnUpdate = findViewById(R.id.btnUpdateGame)

        // Recuperar juego desde el intent
        game = intent.getParcelableExtra("game") ?: run {
            Toast.makeText(this, "Error al cargar juego", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // Prellenar los datos
        etTitle.setText(game.title)
        etGenre.setText(game.genre)
        ratingBar.rating = game.rating

        btnUpdate.setOnClickListener {
            val newTitle = etTitle.text.toString().trim()
            val newGenre = etGenre.text.toString().trim()
            val newRating = ratingBar.rating

            if (newTitle.isEmpty() || newGenre.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val updatedGame = game.copy(
                title = newTitle,
                genre = newGenre,
                rating = newRating
            )

            val userId = auth.currentUser?.uid ?: return@setOnClickListener

            database.child("games").child(userId).child(game.id)
                .setValue(updatedGame)
                .addOnSuccessListener {
                    Toast.makeText(this, "Juego actualizado", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error al actualizar", Toast.LENGTH_SHORT).show()
                }
        }
    }
}
