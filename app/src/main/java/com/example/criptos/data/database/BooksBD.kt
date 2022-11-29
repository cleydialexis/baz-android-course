package com.example.criptos.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.criptos.data.database.dao.CryptoCurrencyDao
import com.example.criptos.ui.adapter.entities.AsksEntity
import com.example.criptos.ui.adapter.entities.AvailableBookEntity
import com.example.criptos.ui.adapter.entities.BidsEntity
import com.example.criptos.ui.adapter.entities.TickerEntity

@Database(entities = [AvailableBookEntity::class, TickerEntity::class, AsksEntity::class, BidsEntity::class], version = 1)
abstract class CriptoCurrencyDB : RoomDatabase() {
    abstract fun getCriptoCurrencyDao(): CryptoCurrencyDao
}