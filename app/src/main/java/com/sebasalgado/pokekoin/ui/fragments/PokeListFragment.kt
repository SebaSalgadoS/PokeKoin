package com.sebasalgado.pokekoin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.sebasalgado.pokekoin.R
import com.sebasalgado.pokekoin.data.model.PokeResponse
import com.sebasalgado.pokekoin.data.model.Pokemon
import com.sebasalgado.pokekoin.databinding.FragmentPokeListBinding
import com.sebasalgado.pokekoin.ui.adapter.PokemonAdapter
import com.sebasalgado.pokekoin.ui.viewmodel.PokeListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokeListFragment : Fragment() {

    private val pokeViewModel by viewModel<PokeListViewModel>()
    private val biding by lazy { FragmentPokeListBinding.inflate(layoutInflater) }
    private val pokeAdapter by lazy {
        PokemonAdapter(adapterManager = PokeManager())
    }

    inner class PokeManager : PokemonAdapter.AdapterManager {
        override fun onPokeClickListener(poke: PokeResponse) {
            onItemSelected(poke)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return biding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initViewModel()
        initObserver()
    }

    private fun initRecyclerView() {
        val recyclerView = biding.myRecyclerView
        recyclerView.layoutManager
        recyclerView.adapter = pokeAdapter
    }

    private fun initViewModel() {
        pokeViewModel.getAllPokemons()
    }

    fun initObserver() {
        pokeViewModel.repositoryModel.observe(viewLifecycleOwner, Observer {
            pokeAdapter.updateAdapter(it)
        })
    }

    private fun onItemSelected(poke: PokeResponse) {
        val action =
            PokeListFragmentDirections.actionPokeListFragmentToPokeDetailFragment(pokeName = poke.name)
        findNavController().navigate(action)
    }
}