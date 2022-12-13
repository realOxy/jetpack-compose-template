package com.sortby.composetemplate.di

import com.sortby.composetemplate.ext.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.time.Duration
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(ApiDefaults.BASE_URL)
            .addConverterFactory(ApiDefaults.json.asConverterFactory(contentType))
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient.Builder()
            .writeTimeout(0L, TimeUnit.MINUTES)
            .readTimeout(1L, TimeUnit.MINUTES)
            .pingInterval(Duration.ofSeconds(8))
            .addInterceptor { chain ->
                val original = chain.request()
                val request = original.newBuilder()
                    .method(original.method, original.body)
                    .build()
                chain.proceed(request)
            }
            .build()
        return client
    }
}

internal object ApiDefaults {
    const val BASE_URL = ""
    val json by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }
}