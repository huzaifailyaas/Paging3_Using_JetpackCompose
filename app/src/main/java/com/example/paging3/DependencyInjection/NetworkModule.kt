package com.example.paging3.DependencyInjection

import com.example.paging3.Util.Constants.BASE_URL
import com.example.paging3.data.UnsplashApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHTTPClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val contentType = MediaType.get("application/json")
        val json=Json{
            ignoreUnknownKeys=true
        }

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

    fun provideUnsplashApi(retrofit: Retrofit):UnsplashApi{
        return retrofit.create(UnsplashApi::class.java)
    }
}