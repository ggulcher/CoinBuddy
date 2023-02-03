package com.example.coinbuddy.di

import com.example.coinbuddy.api.ApiService
import com.example.coinbuddy.api.repository.CoinRepository
import com.example.coinbuddy.api.repository.CoinRepositoryImpl
import com.example.coinbuddy.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesDashCoinRepository(
        api: ApiService
    ): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}
