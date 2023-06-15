package com.example.composeapp.di

import com.example.composeapp.data.network.ApiRepository
import com.example.composeapp.data.network.ApiService
import com.example.composeapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideFootballApiService(): ApiService {
    val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val interceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("X-RapidAPI-Key", Constants.X_RAPID_KEY)
            .addHeader("X-RapidAPI-Host", Constants.X_RAPID_HOST)
            .build()
        chain.proceed(request)
    }
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(loggingInterceptor)
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    return retrofit.create(ApiService::class.java)
}

    @Provides
    fun provideFootballRepository(apiService: ApiService): ApiRepository {
        return ApiRepository(apiService)
    }

}




