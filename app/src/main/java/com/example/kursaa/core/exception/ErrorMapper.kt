package com.example.kursaa.core.exception

interface ErrorMapper {

    fun map(throwable: Throwable): String
}