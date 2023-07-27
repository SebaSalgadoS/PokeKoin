package com.sebasalgado.pokekoin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import com.sebasalgado.pokekoin.R
import com.sebasalgado.pokekoin.databinding.FragmentPokeDetailBinding
import com.sebasalgado.pokekoin.ui.viewmodel.PokeDetailViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokeDetailFragment : Fragment() {

    private val binding by lazy { FragmentPokeDetailBinding.inflate(layoutInflater) }
    private val pokeViewModel by viewModel<PokeDetailViewModel>()
    private val args: PokeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
    }

    private fun initViewModel(){
        pokeViewModel.getDetailPokemon(pokeName = args.pokeName)

    }

    private fun initObserver(){
        pokeViewModel.repositoryModel.observe(viewLifecycleOwner, Observer { pokemon ->

            with(binding){
                pokeNameDetail.text = pokemon.name
                pokeWeight.text = pokemon.weight.toString()
                pokemonHeight.text = pokemon.height.toString()
                pokemonType.text = pokemon.types.toString()


                Picasso.get().load(pokemon.sprites.front_default).into(imgPokeDetail)

            }


        })
    }

    private fun initDetailView(){

    }
}