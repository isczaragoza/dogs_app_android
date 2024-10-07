package com.isczaragoza.dogsapp.data.network.services

import com.isczaragoza.dogsapp.data.dtos.DogResponseDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

/**Servicio para la implementación de consultas*/
interface DogApiService {
    @GET("api/1151549092634943488")
    suspend fun requestListOfDogs(): Response<List<DogResponseDTO>>
    @GET("api/1151549092634943488")
    suspend fun requestListOfDogsCall(): Call<Unit>
}