package com.example.kursaa.core.network

interface NetworkStateProvider {

    fun isNetworkAvailable(): Boolean
}