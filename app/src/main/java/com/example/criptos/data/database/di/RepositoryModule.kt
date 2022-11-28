package com.example.criptos.data.database.di

import com.example.criptos.data.repository.BitsoRepositoryImp
import com.example.criptos.domain.repository.BitsoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindBitsoRepository(imp: BitsoRepositoryImp): BitsoRepository
}