package com.sortby.composetemplate.data.di

import com.sortby.composetemplate.data.source.api.UserApi
import com.sortby.composetemplate.data.source.dao.AppDatabase
import com.sortby.composetemplate.data.source.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProvideModule {
    @Provides
    @Singleton
    fun provideUserApi(
        retrofit: Retrofit
    ): UserApi {
        return retrofit.create()
    }
    @Provides
    @Singleton
    fun provideUserDao(
        db: AppDatabase
    ): UserDao {
        return db.userDao()
    }
}