package com.sebasalgado.pokekoin.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sebasalgado.pokekoin.data.model.PokeResponse
import com.sebasalgado.pokekoin.data.model.Pokemon
import com.sebasalgado.pokekoin.databinding.PokemonItemBinding
import com.squareup.picasso.Picasso

class PokemonViewHolder(view: View, private val adapterManager: PokemonAdapter.AdapterManager) :
    RecyclerView.ViewHolder(view) {

    val binding = PokemonItemBinding.bind(view)

    fun initViewHolder(poke: PokeResponse) {

        with(binding) {
            txtPokeName.text = poke.name
            pokeContainer.setOnClickListener {
                adapterManager.onPokeClickListener(poke)
            }
           //Picasso.get().load(poke.url).into(imgPokemon)

        }

    }

}