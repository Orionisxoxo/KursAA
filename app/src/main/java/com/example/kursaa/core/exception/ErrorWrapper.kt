package com.example.kursaa.core.exception

interface ErrorWrapper {

    fun wrap(throwable: Throwable): Throwable
}