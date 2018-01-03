package com.kh.salvager.data

interface DataOperationCallback<T> {
    fun onSuccess(data: T)
    fun onError(throwable: Throwable)
}