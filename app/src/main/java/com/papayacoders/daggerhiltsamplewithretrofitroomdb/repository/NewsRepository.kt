package com.papayacoders.daggerhiltsamplewithretrofitroomdb.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.papayacoders.daggerhiltsamplewithretrofitroomdb.di.ApiInterface
import com.papayacoders.daggerhiltsamplewithretrofitroomdb.models.NewsData
import com.papayacoders.daggerhiltsamplewithretrofitroomdb.utils.NetworkResult
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiInterface: ApiInterface) {

    private val _newsLiveData = MutableLiveData<NetworkResult<NewsData>>()
    val newsLiveData: LiveData<NetworkResult<NewsData>>
        get() = _newsLiveData

    suspend fun getNews(category: String) {

        val response = apiInterface.getNews(category)


        if (response.isSuccessful && response.body() != null) {
            _newsLiveData.postValue(NetworkResult.Success(response.body()))
        } else if (response.errorBody() != null) {

            _newsLiveData.postValue(NetworkResult.Error("Something went wrong"))
        } else {
            _newsLiveData.postValue(NetworkResult.Error("Something went wrong"))

        }

    }

}