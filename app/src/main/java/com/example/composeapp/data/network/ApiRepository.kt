package com.example.composeapp.data.network


import com.example.composeapp.data.models.Resp
import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getFixtures(): List<Resp> {
        val apiResult = apiService.getGameInfo()
        return apiResult.resp
    }
}



