package com.example.mvvmarc.base.network

/**
 * This NetworkResult sealed class using for to get network result.
 * @param Success when get result as a success, then passing data with the class.
 *  @param Error when get result as an Error, then passing data and error messages with the class.
 *  @param Loading when being calling the API loading, then passing Loading class.
 */
sealed class NetworkResult<T>(
  val data: T? = null,
  val message: String? = null
) {
  class Success<T>(data: T) : NetworkResult<T>(data)
  class Error<T>(
    message: String,
    data: T? = null
  ) : NetworkResult<T>(data, message)

  class Loading<T> : NetworkResult<T>()
}