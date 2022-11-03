package com.example.cripto.data.repositories


import com.example.cripto.data.ApiRepository

import com.example.cripto.data.source.remote.ApiService
import com.example.cripto.data.source.remote.dto.toListCoins
import com.example.cripto.domain.model.Coins
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

/*
class CoinsRepositoryImpl @Inject constructor(
    private val dataSource: ApiService
): ApiRepository {
    override fun getbook(): Flow<Result<List<Coins>>> = flow{
        emit(Result.Loading())
        try {
            val response = dataSource.getAvailableBooks().toListCoins()
            emit(Result.Success(response))
        } catch (e: HttpException) {
            emit(Result.Error(
                message = "Oops, something went wrong",
                data = null
            ))
        } catch (e: IOException) {
            emit(Result.Error(
                message = "Couldn't reach server, check your internet connection",
                data = null
            ))
        }
    }
    }

override suspend fun getbook(id: Int): Result<Character> {
    val response = try {
        dataSource.getCharacter(id)
    } catch (e: Exception) {
        return Result.Error("An unknown error occurred")
    }
    return Result.Success(response.toCharacter())
}

}*/