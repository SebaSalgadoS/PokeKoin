package com.sebasalgado.pokekoin.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebasalgado.pokekoin.data.model.PokeResponse
import com.sebasalgado.pokekoin.data.model.Pokemon
import com.sebasalgado.pokekoin.domain.GetPokemonUseCase
import kotlinx.coroutines.launch

class PokeDetailViewModel(private val data: GetPokemonUseCase) : ViewModel() {

    val repositoryModel = MutableLiveData<Pokemon>()

    fun getDetailPokemon(pokeName: String) {
        viewModelScope.launch {
            repositoryModel.postValue(data.loadDetailPokemon(pokeName = pokeName))
        }
    }

}