package com.papayacoders.daggerhiltsamplewithretrofitroomdb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.papayacoders.daggerhiltsamplewithretrofitroomdb.models.NewsData
import com.papayacoders.daggerhiltsamplewithretrofitroomdb.repository.NewsRepository
import com.papayacoders.daggerhiltsamplewithretrofitroomdb.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository)
    : ViewModel(){

    val newsLiveData: LiveData<NetworkResult<NewsData>>
        get() = repository.newsLiveData

    fun getNews(category: String){

        viewModelScope.launch {
            repository.getNews(category)
        }
    }


}