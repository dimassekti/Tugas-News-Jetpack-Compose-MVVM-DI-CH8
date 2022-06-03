package com.coufie.news_jetpackcompose_mvvm_di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coufie.news_jetpackcompose_mvvm_di.NewsRepository
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseNewsItem
import com.coufie.news_jetpackcompose_mvvm_di.data.ResponseStafItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StafViewModel @Inject constructor(private val api : NewsRepository) : ViewModel() {


    private val stafState = MutableStateFlow(emptyList<ResponseStafItem>())
    val dataState : StateFlow<List<ResponseStafItem>> get() = stafState

    init{
        viewModelScope.launch {
            val staf = api.getStaf()
            stafState.value = staf
        }
    }
}