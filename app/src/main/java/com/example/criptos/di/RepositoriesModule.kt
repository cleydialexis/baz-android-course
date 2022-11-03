package com.example.cripto.di

import com.example.cripto.data.repositories.CoinsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)

abstract class RepositoriesModule {
    @Binds
    abstract fun bindCoinsRepository(impl: CoinsRepositoryImpl): CoinsRepositoryImpl
}