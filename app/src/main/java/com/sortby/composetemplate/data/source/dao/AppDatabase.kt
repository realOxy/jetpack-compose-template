package com.sortby.composetemplate.data.source.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sortby.composetemplate.data.entity.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}