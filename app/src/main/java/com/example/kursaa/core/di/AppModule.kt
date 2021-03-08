package com.example.kursaa.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kursaa.core.exception.ErrorMapper
import com.example.kursaa.core.exception.ErrorMapperImpl
import com.example.kursaa.core.exception.ErrorWrapper
import com.example.kursaa.core.exception.ErrorWrapperImpl
import com.example.kursaa.core.network.NetworkStateProvider
import com.example.kursaa.core.network.NetworkStateProviderImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    factory { LinearLayoutManager(get()) }
    factory { GridLayoutManager(get(), 2) }
    factory { DividerItemDecoration(get(), LinearLayoutManager.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
}