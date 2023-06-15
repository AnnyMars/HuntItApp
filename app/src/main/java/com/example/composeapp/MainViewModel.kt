package com.example.composeapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeapp.data.models.ApiResult
import com.example.composeapp.data.models.Resp
import com.example.composeapp.data.network.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository): ViewModel() {

    private val _resp = MutableLiveData<List<Resp>>()
    val resp: LiveData<List<Resp>> get() = _resp

    fun getGameInfo() {
        viewModelScope.launch {
            _resp.value = repository.getFixtures()
        }
    }
}
//    private val _resp = MutableLiveData<ApiResult>()
//    val resp: LiveData<ApiResult> get() = _resp
//
//    fun getRace(){
//        viewModelScope.launch {
//            try {
//                val result = repository.getFixtures()
//                _resp.value = result
//            } catch (e: Exception){
//
//            }
//        }
//    }
