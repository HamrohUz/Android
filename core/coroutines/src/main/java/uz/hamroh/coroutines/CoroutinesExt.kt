package uz.hamroh.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout

fun CoroutineScope.launchIO(block: suspend CoroutineScope.() -> Unit) =
    this.launch(Dispatchers.IO) { block() }

fun CoroutineScope.launchMain(block: suspend CoroutineScope.() -> Unit) =
    this.launch(Dispatchers.Main) { block() }
suspend fun <T> withTimeoutOrNullWrapper(timeoutMillis: Long, block: suspend () -> T): T? =
    withTimeout(timeoutMillis) { block() }

fun CoroutineScope.launchWithDispatcher(
    dispatcher: CoroutineDispatcher,
    block: suspend CoroutineScope.() -> Unit
) = launch(dispatcher) { block() }

fun <T> CoroutineScope.asyncWithDispatcher(
    dispatcher: CoroutineDispatcher,
    block: suspend CoroutineScope.() -> T
): Deferred<T> = async(dispatcher) { block() }

fun CoroutineScope.safeLaunch(
    errorHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Error caught: $exception")
    },
    block: suspend CoroutineScope.() -> Unit
) = launch(coroutineContext + errorHandler) { block() }
