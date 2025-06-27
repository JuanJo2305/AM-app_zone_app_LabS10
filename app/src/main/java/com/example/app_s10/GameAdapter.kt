package com.example.app_s10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(private var games: List<Game>,
                  private val onClick: (Game) -> Unit,
                  private val onLongClick: (Game) -> Unit
) :
    RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvGameTitle)
        val tvGenre: TextView = itemView.findViewById(R.id.tvGameGenre)
        val ratingBar: RatingBar = itemView.findViewById(R.id.ratingBarItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.tvTitle.text = game.title
        holder.tvGenre.text = game.genre
        holder.ratingBar.rating = game.rating

        holder.itemView.setOnClickListener { onClick(game) }
        holder.itemView.setOnLongClickListener {
            onLongClick(game)
            true
        }
    }

    override fun getItemCount() = games.size

    fun updateGames(newGames: List<Game>) {
        games = newGames
        notifyDataSetChanged()
    }
}