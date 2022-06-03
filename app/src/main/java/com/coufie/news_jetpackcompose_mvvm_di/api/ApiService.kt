package com.coufie.news_jetpackcompose_mvvm_di.api

import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseNewsItem
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseStafItem
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    suspend fun getAllNews(): List<ResponseNewsItem>

    @GET("staf")
    suspend fun getAllStaf(): List<ResponseStafItem>
}