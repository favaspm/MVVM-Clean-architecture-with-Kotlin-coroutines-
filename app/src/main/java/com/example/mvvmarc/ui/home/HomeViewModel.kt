package com.example.mvvmarc.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import com.example.mvvmarc.base.BaseViewModel
import com.example.mvvmarc.base.network.NetworkResult
import com.example.mvvmarc.model.response.ArticleResponse
import com.example.mvvmarc.repository.ApiRepository
import com.example.mvvmarc.utils.GeneralUtils.checkInternet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    private val apiRepository: ApiRepository,
) : BaseViewModel(application) {


    private val _articleLiveData = MutableLiveData<NetworkResult<ArticleResponse>>()
    val articleLiveData: LiveData<NetworkResult<ArticleResponse>> get() = _articleLiveData



    fun getArticle() {

        if (isValidate()) {
            viewModelScope.launch {
                apiRepository.getArticle().collect {
                    _articleLiveData.value = it
                }

            }

        }
    }

    private fun isValidate(): Boolean {
            if (!context.checkInternet()){
                _articleLiveData.value=NetworkResult.Error("Please check your internet connection!")
                return false
            }
        return true
    }


}