package com.sebasalgado.pokekoin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebasalgado.pokekoin.data.model.PokeResponse
import com.sebasalgado.pokekoin.data.model.Pokemon
import com.sebasalgado.pokekoin.domain.GetPokemonUseCase
import kotlinx.coroutines.launch

class PokeListViewModel(val data : GetPokemonUseCase): ViewModel() {

    val repositoryModel = MutableLiveData<List<PokeResponse>>()

    fun getAllPokemons() {
        viewModelScope.launch {
            repositoryModel.postValue(data.loadListPokemon())
            println("DATA REPO VIEW MODEL" + data.loadListPokemon())
        }
    }
}