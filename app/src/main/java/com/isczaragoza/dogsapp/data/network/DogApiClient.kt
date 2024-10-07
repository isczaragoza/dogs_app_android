package com.isczaragoza.dogsapp.data.network

import com.isczaragoza.dogsapp.data.dtos.DogResponseDTO

/**Contrato*/
interface DogApiClient {
    suspend fun requestListOfDogs(): List<DogResponseDTO>?
}