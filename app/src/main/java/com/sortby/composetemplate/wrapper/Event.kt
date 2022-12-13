package com.sortby.composetemplate.wrapper

open class Event<out T>(
    private val data: T?
) {
    protected open var isHandled: Boolean = false
    fun peekOrNull(): T? = if (isHandled) null else data
    fun handle(handler: (T) -> Unit) {
        if (!isHandled) {
            handler(data!!)
            isHandled = true
        }
    }

    class Handled<out T> : Event<T>(null) {
        override var isHandled = true
    }
}

fun <T> eventOf(data: T): Event<T> = Event(data)