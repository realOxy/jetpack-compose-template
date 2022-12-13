package com.sortby.composetemplate.wrapper

private const val DEFAULT_CODE = 200

data class BackendResult<out T>(
    val data: T? = null,
    val code: Int = DEFAULT_CODE,
    val msg: String? = null
)

fun <T> BackendResult<T>.onSuccess(block: (T) -> Unit): BackendResult<T> {
    if (code == DEFAULT_CODE) {
        checkNotNull(data)
        block(data)
    }
    return this
}


fun <T> BackendResult<T>.onFailure(block: (String?) -> Unit): BackendResult<T> {
    if (code != DEFAULT_CODE) {
        block(msg)
    }
    return this
}