package com.isczaragoza.dogsapp.framework.networkImpl

import com.isczaragoza.dogsapp.data.network.services.DogApiService
import com.isczaragoza.dogsapp.data.dtos.DogResponseDTO
import com.isczaragoza.dogsapp.data.network.DogApiClient
import retrofit2.Retrofit

class DogRetrofitApiClientImp(
    //private val httpClientProvider: HttpClientProvider,
    private val retrofit: Retrofit
) : DogApiClient {
    //private val retrofit: Retrofit = httpClientProvider.provideHttpClient() as Retrofit
    override suspend fun requestListOfDogs(): List<DogResponseDTO>? {
        return retrofit.create(DogApiService::class.java).requestListOfDogs().body()
    }
}