package com.isczaragoza.dogsapp.framework.networkImpl

import com.isczaragoza.dogsapp.data.network.HttpClientProvider
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


class RetrofitClientProvider : HttpClientProvider {
    private val networkJson: Json = Json { ignoreUnknownKeys = true }
    override fun provideHttpClient(): Retrofit {
        return Retrofit.Builder().baseUrl("https://jsonblob.com/")
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .build()
    }
}