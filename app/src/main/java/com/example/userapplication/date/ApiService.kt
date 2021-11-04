package com.example.userapplication.date

import com.example.userapplication.model.UserRespons
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/users/{username}/repos")
    suspend fun getUsers(
        @Header("accept") accept: String,
        @Path("username") username: String,
        @Query("type") type: String,
        @Query("sort") sort: String,
        @Query("direction")direction :String,
        @Query("per_page")per_page : Int,
        @Query("page")page : Int
    ): Response<List<UserRespons>>
}