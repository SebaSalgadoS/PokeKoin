package com.sebasalgado.pokekoin.domain

import android.util.Log
import com.sebasalgado.pokekoin.data.model.PokeResponse
import com.sebasalgado.pokekoin.data.model.Pokemon
import com.sebasalgado.pokekoin.data.network.PokeKoinApiService

class GetPokemonUseCase(val apiService: PokeKoinApiService) {

    suspend fun loadDetailPokemon(pokeName : String): Pokemon?{
        val response = apiService.getPokemon(pokeName)
        return if (response.isSuccessful){
            val pokemon = response.body()
            pokemon
        }else{
            Log.e("ERROR USECASE", response.errorBody().toString())
            error("error al cargar")
        }

    }

    suspend fun loadListPokemon(): List<PokeResponse>{
        val response = apiService.getPokemonList()
        return if (response.isSuccessful){
            val pokeList = response.body()?.pokeResponse ?: emptyList()
            pokeList
        }else{
            Log.e("ERROR USECASE", response.errorBody().toString())
            emptyList()
        }
    }
}