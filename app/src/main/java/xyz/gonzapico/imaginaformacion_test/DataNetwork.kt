package xyz.gonzapico.imaginaformacion_test

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataNetwork {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TypicodeAPI::class.java)
    }
}