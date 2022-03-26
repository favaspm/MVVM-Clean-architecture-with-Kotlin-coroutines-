package com.example.mvvmarc.di

import android.content.Context
import com.example.mvvmarc.data.local.LocalData
import com.example.mvvmarc.data.remote.ApiService
import com.example.mvvmarc.repository.ApiRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object  AppModule {

    @Provides
    fun provideApi(apiService: ApiService): ApiRepository {
        return ApiRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideLocalData(@ApplicationContext context: Context,gson: Gson): LocalData {
        return LocalData(context,gson)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }
}