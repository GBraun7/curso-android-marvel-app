package com.example.marvelapp.framework.remote

import com.braun.gustavo.core.data.repository.CharactersRemoteDataSource
import com.example.marvelapp.framework.network.MarvelAPI
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import javax.inject.Inject

class RetrofitCharactersDataSource @Inject constructor(
    private val marvelApi: MarvelAPI
) : CharactersRemoteDataSource<DataWrapperResponse> {

    override suspend fun fetchCharacters(queries: Map<String, String>): DataWrapperResponse {
        return marvelApi.getCharacters(queries)
    }
}