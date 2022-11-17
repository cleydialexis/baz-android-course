package com.example.criptos.data

import android.content.Context
import androidx.room.Room
import com.example.criptos.data.models.CoinListDTO.CoinListDto
import com.example.criptos.domain.repository.database.BooksBD
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): BooksBD{
        return Room
            .databaseBuilder(
                context,
                BooksBD::class.java,
                "BooksDatabase"
            )
            .build()
    }

    @Singleton
    @Provides
    fun provideCoinsListDTO(booksBD: BooksBD): CoinListDto {
        return booksBD.coinListDto()
    }

}