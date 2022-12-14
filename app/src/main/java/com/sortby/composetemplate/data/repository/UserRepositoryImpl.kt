package com.sortby.composetemplate.data.repository

import com.sortby.composetemplate.data.entity.User
import com.sortby.composetemplate.data.source.UserLocalDataSource
import com.sortby.composetemplate.data.source.api.UserApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val local: UserLocalDataSource,
    private val api: UserApi
) : UserRepository {
    override fun observeAll(): Flow<List<User>> {
        return local.userDao.observeAll()
    }

    override suspend fun refreshLatestUsers() {
        api.getAll().forEach { local.userDao.insert(it) }
    }
}