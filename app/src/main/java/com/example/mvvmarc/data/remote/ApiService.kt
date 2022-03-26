package com.example.mvvmarc.data.remote

import com.example.mvvmarc.model.response.ArticleResponse
import com.example.mvvmarc.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

/**
 * This class use for entire application API call request to register.
 */
interface ApiService {

   @GET(Constants.API_ARTICLE)
   suspend fun getArticle():Response<ArticleResponse>


}