package com.example.mvvmarc.repository

import com.example.mvvmarc.data.remote.ApiService
import com.example.mvvmarc.base.network.BaseApiResponse
import com.example.mvvmarc.base.network.NetworkResult
import com.example.mvvmarc.model.response.ArticleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiService: ApiService
) : BaseApiResponse() {

    suspend fun getArticle() : Flow<NetworkResult<ArticleResponse>> {
         return flow {
           emit(NetworkResult.Loading())
           emit(safeApiCall { apiService.getArticle() })
       }.flowOn(Dispatchers.IO)
    }


}