package com.kh.domain.data

interface DataOperationCallback<T> {
    fun onSuccess(data: T)
    fun onError(throwable: Throwable)
}