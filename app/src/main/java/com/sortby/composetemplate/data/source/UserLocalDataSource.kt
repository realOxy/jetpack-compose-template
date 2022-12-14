package com.sortby.composetemplate.data.source

import com.sortby.composetemplate.data.source.dao.UserDao
import javax.inject.Inject

class UserLocalDataSource @Inject constructor(
    val userDao: UserDao
)