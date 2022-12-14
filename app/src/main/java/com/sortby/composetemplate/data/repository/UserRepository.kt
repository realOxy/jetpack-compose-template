package com.sortby.composetemplate.data.repository

import com.sortby.composetemplate.data.entity.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun observeAll(): Flow<List<User>>
    suspend fun refreshLatestUsers()
}