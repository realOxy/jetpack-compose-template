package com.sortby.composetemplate.data.repository

import com.sortby.composetemplate.data.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class UserRepositoryMock(
    initial: List<User>
) : UserRepository {
    private val users = MutableStateFlow(initial)
    override fun observeAll(): Flow<List<User>> {
        return users
    }

    override suspend fun refreshLatestUsers() {
        val list = users.value.shuffled()
        users.emit(list)
    }
}