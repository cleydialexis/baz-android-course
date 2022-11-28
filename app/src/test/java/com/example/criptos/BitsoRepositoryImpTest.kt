package com.example.criptos

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.criptos.data.repository.BitsoRepositoryImp
import com.example.criptos.data.remote.BitsoApi
import com.example.criptos.data.database.data_source.CryptoCurrencyLocalDataSource
import com.example.criptos.domain.repository.model.OrderBook
import com.example.criptos.ui.adapter.entities.toAsksEntityList
import com.example.criptos.ui.adapter.entities.toAvailableBookEntityList
import com.example.criptos.ui.adapter.entities.toBidsEntityList
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BitsoRepositoryImpTest {

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private val remoteDataSource: BitsoApi = mockk()
    private val localDataSource: CryptoCurrencyLocalDataSource = mockk()
    private var context: Context = mockk()

    private lateinit var systemUnderTest: BitsoRepositoryImp

    @Before
    fun onBefore() {
        systemUnderTest = BitsoRepositoryImp(
            remoteDataSource,
            localDataSource,
            context
        )
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `insert available books to database function when empty`() = runBlocking {
        // Given
        every { localDataSource.getAllAvailableBooksFromDatabase() } returns emptyList()

        // When
        systemUnderTest.updateAvailableOrderBookDatabase(listAvailableOrderBooks)

        // Then
        verify(exactly = 1) {
            localDataSource.insertAvailableOrderBookToDatabase(listAvailableOrderBooks.toAvailableBookEntityList())
        }
    }

    @Test
    fun `Avoid insert available books to database function when has data already`() = runBlocking {
        // Given
        every { localDataSource.getAllAvailableBooksFromDatabase() } returns listAvailableOrderBooksEntities

        // When
        systemUnderTest.updateAvailableOrderBookDatabase(listAvailableOrderBooks)

        // Then
        verify(exactly = 0) {
            localDataSource.insertAvailableOrderBookToDatabase(listAvailableOrderBooksEntities)
        }
    }

    @Test
    fun `update available books to database function when has stored data`() = runBlocking {
        // Given
        every { localDataSource.getAllAvailableBooksFromDatabase() } returns listAvailableOrderBooksEntities

        // When
        systemUnderTest.updateAvailableOrderBookDatabase(listAvailableOrderBooks)

        // Then
        verify(exactly = 1) {
            localDataSource.updateAvailableOrderBookDatabase(listAvailableOrderBooksEntities)
        }
    }

    @Test
    fun `delete  Order books to database functions when called`() = runBlocking {
        // Given
        val book = "btc_mxn"
        val orderBookEmpty = OrderBook(book, emptyList(), emptyList())

        // When
        systemUnderTest.updateOrderBookDatabase(book, orderBookEmpty)

        // Then
        verify(exactly = 1) {
            localDataSource.deleteOpenOrdersFromDatabase(book)
        }
    }

    @Test
    fun `insert Order books to database even when empty`() =
        runBlocking {
            // Given
            val book = "btc_mxn"
            val orderBookEmpty = OrderBook(book, emptyList(), emptyList())

            // When
            systemUnderTest.updateOrderBookDatabase(book, orderBookEmpty)

            // Then
            verify(exactly = 1) {
                localDataSource.insertOpenOrdersToDatabase(
                    orderBookEmpty.bids.toBidsEntityList(),
                    orderBookEmpty.asks.toAsksEntityList()
                )
            }
        }
}