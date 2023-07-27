package com.sebasalgado.pokekoin.data.network

import com.sebasalgado.pokekoin.data.model.PokeList
import com.sebasalgado.pokekoin.data.model.PokeResponse
import com.sebasalgado.pokekoin.data.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeKoinApiService {

    @GET("pokemon?offset=20&limit=35")
    suspend fun getPokemonList(): Response<PokeList>

    @GET("pokemon/{name}/")
    suspend fun getPokemon(@Path("name") name : String): Response<Pokemon>

}