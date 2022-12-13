package com.sortby.composetemplate.wrapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Failure(val msg: String?) : Resource<Nothing>()
}

inline fun <T> resourceFlow(
    crossinline collector: FlowCollector<Resource<T>>.() -> Unit
): Flow<Resource<T>> = flow {
    emit(Resource.Loading)
    collector(this)
}

suspend fun <T> FlowCollector<Resource<T>>.emitResource(t: T) = emit(Resource.Success(t))

suspend fun <T> FlowCollector<Resource<T>>.emitFailedResource(msg: String? = null) =
    emit(Resource.Failure(msg))
