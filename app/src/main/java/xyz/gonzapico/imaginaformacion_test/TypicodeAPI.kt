package xyz.gonzapico.imaginaformacion_test

import retrofit2.http.GET

interface TypicodeAPI {

    // https://jsonplaceholder.typicode.com/users
    @GET("users")
    suspend fun getUsers(): List<UserModel>
}