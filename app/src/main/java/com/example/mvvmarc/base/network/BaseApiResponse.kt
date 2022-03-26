package com.example.mvvmarc.base.network

import android.util.Log
import org.json.JSONObject
import retrofit2.Response

/**
 * @param BaseApiResponse this class is a abstract class which is intended to use for wherever going to
 * make api calls ,that where we must should use the base class.
 */
abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): NetworkResult<T> {
        try {
            var message = ""
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                }
            } else {
                if (response.errorBody() != null) {
                    message = JSONObject(response.errorBody()!!.string()).getString("message")
                }
            }
            Log.e("errorRetrofit", "${response.code()} ${response.message()}")


            if (message.isEmpty()) {
                message = "Api call failed :${response.code()} ${response.message()}"
            }
            return error(message)
        } catch (e: Exception) {
            e.printStackTrace()
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): NetworkResult<T> =
        NetworkResult.Error(errorMessage)
}