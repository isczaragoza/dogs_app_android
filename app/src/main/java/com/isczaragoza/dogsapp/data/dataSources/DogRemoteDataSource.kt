package com.isczaragoza.dogsapp.data.dataSources

import com.isczaragoza.dogsapp.data.network.DogApiClient
import com.isczaragoza.dogsapp.data.dtos.DogResponseDTO

class DogRemoteDataSource(private val dogApiClient: DogApiClient) {
    suspend fun requestListOfDogs(): List<DogResponseDTO>? {
        return dogApiClient.requestListOfDogs()
    }
}