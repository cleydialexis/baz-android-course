package com.example.criptos.data.database.data_source

import com.example.criptos.data.database.dao.CryptoCurrencyDao
import com.example.criptos.ui.adapter.entities.AsksEntity
import com.example.criptos.ui.adapter.entities.AvailableBookEntity
import com.example.criptos.ui.adapter.entities.BidsEntity
import com.example.criptos.ui.adapter.entities.TickerEntity
import javax.inject.Inject

class CryptoCurrencyLocalDataSource @Inject constructor(
    private val cryptoCurrencyDao: CryptoCurrencyDao
) {

    /*AvailableBooks*/
    fun getAllAvailableBooksFromDatabase(): List<AvailableBookEntity> =
        cryptoCurrencyDao.getAllAvailableBooksFromDatabase()

    fun insertAvailableOrderBookToDatabase(bookList: List<AvailableBookEntity>) =
        cryptoCurrencyDao.insertAvailableOrderBookToDatabase(bookList)

    fun updateAvailableOrderBookDatabase(bookList: List<AvailableBookEntity>) =
        cryptoCurrencyDao.updateAvailableOrderBookDatabase(bookList)

    fun deleteAllAvailableBooksDatabase() =
        cryptoCurrencyDao.deleteAllAvailableBooksDatabase()

    /*Tickers*/
    fun getTickerFromDatabase(book: String): TickerEntity =
        cryptoCurrencyDao.getTickerFromDatabase(book)

    fun insertTickerToDatabase(ticker: TickerEntity) =
        cryptoCurrencyDao.insertTickerToDatabase(ticker)

    fun updateTickerDatabase(ticker: TickerEntity) =
        cryptoCurrencyDao.updateTickerDatabase(ticker)

    fun deleteTickerDatabase(book: String) =
        cryptoCurrencyDao.deleteTickerDatabase(book)

    /*OrderBooks*/
    fun getOrderBookfromDatabase(book: String) =
        cryptoCurrencyDao.getOrderBookFromDatabase(book)

    fun insertOpenOrdersToDatabase(
        bidsEntityList: List<BidsEntity>,
        asksEntityList: List<AsksEntity>
    ) =
        cryptoCurrencyDao.insertOrderBookOpenOrdersFromDatabase(bidsEntityList, asksEntityList)

    fun deleteOpenOrdersFromDatabase(book: String) =
        cryptoCurrencyDao.deleteOrderBookOpenOrdersFromDatabase(book)
}