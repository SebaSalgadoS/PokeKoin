package com.sebasalgado.pokekoin.di

import com.sebasalgado.pokekoin.data.network.PokeKoinApiService
import com.sebasalgado.pokekoin.domain.GetPokemonUseCase
import com.sebasalgado.pokekoin.ui.viewmodel.PokeDetailViewModel
import com.sebasalgado.pokekoin.ui.viewmodel.PokeListViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val ApiModule = module {

    single {
        OkHttpClient.Builder().build()
    }

    single {
        Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create()).client(get()).build()
            .create(PokeKoinApiService::class.java)
    }

    single {
        GetPokemonUseCase(get())
    }

    viewModel{
        PokeListViewModel(get())
    }

    viewModel{
        PokeDetailViewModel(get())
    }

}