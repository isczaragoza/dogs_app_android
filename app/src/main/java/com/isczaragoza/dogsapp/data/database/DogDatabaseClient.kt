package com.isczaragoza.dogsapp.data.database

import com.isczaragoza.dogsapp.domain.entities.DogEntity
import kotlinx.coroutines.flow.Flow

/**Contrato*/
interface DogDatabaseClient {
    suspend fun insertListOfDogs(listOfDogs: List<DogEntity>)
    fun getListOfDogs(): Flow<List<DogEntity>>
}