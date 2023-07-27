package com.sebasalgado.pokekoin.data.model

import com.google.gson.annotations.SerializedName

data class PokeList(
    val count: Int,
    val next: String,
    val previous: String,
    @SerializedName("results") val pokeResponse: List<PokeResponse>
)

data class PokeResponse(
    val name: String,
    val url: String
)