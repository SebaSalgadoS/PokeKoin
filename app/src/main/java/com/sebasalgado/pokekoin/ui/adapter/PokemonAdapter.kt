package com.sebasalgado.pokekoin.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sebasalgado.pokekoin.R
import com.sebasalgado.pokekoin.data.model.PokeList
import com.sebasalgado.pokekoin.data.model.PokeResponse
import com.sebasalgado.pokekoin.data.model.Pokemon
import com.sebasalgado.pokekoin.databinding.PokemonItemBinding

class PokemonAdapter(
    private val adapterManager: AdapterManager
) :
    RecyclerView.Adapter<PokemonViewHolder>() {

    private val items: MutableList<PokeResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(view, adapterManager)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val poke = items.get(position)
        holder.initViewHolder(poke)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface AdapterManager {
        fun onPokeClickListener(poke: PokeResponse)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(newItems: List<PokeResponse>){
        items += newItems
        notifyDataSetChanged()
    }
}