package com.coufie.news_jetpackcompose_mvvm_di

import com.coufie.news_jetpackcompose_mvvm_di.api.ApiService
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseNewsItem
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseStafItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsapi : ApiService){


    suspend fun getNews() : List<ResponseNewsItem>{
        return newsapi.getAllNews()
    }

    suspend fun getStaf() : List<ResponseStafItem>{
        return newsapi.getAllStaf()
    }
}