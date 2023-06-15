package com.example.composeapp.data.network



import com.example.composeapp.data.models.ApiResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
        @GET("fixtures")
        suspend fun getGameInfo(@Query("live") live: String = "all"): ApiResult
}


