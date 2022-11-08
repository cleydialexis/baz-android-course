package com.example.cripto

import com.example.cripto.data.source.remote.ApiService

import com.example.cripto.data.source.remote.dto.CoinsDto

class RemoteDataSourceImpl (
    private val service: ApiService
): RemoteDataSource {
    override suspend fun getAvailableBooks(): CoinsDto {
        return service.getAvailableBooks()
    }
}