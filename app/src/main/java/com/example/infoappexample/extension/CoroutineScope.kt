package com.example.infoappexample.extension

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun <T> CoroutineScope.launch(
    liveData: MutableLiveData<Result<T>>,
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> T
) = launch(context + liveData.exceptionHandler) { liveData.postSuccess(block()) }

sealed class Result<T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error<T>(val error: Throwable) : Result<T>()
    data class Loading<T>(val data: T? = null) : Result<T>()
}

val <T> MutableLiveData<Result<T>>.exceptionHandler: CoroutineExceptionHandler
    get() = CoroutineExceptionHandler { _, e -> postError(e) }

fun <T> MutableLiveData<Result<T>>.postSuccess(data: T) = postValue(Result.Success<T>(data))

fun <T> MutableLiveData<Result<T>>.postError(error: Throwable) = postValue(Result.Error<T>(error))

fun <T> MutableLiveData<Result<T>>.postLoading(data: T? = null) = postValue(Result.Loading<T>(data))