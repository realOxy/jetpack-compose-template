package com.sortby.composetemplate.data.source.api

import com.sortby.composetemplate.data.entity.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {
    @GET("/users")
    suspend fun getAll(): List<User>

    @GET("/users/{id}")
    suspend fun getById(@Path("id") id: Int): User?

}