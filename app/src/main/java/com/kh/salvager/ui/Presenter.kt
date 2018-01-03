package com.kh.salvager.ui

interface Presenter<T> {
    fun attachView(view: T)
}