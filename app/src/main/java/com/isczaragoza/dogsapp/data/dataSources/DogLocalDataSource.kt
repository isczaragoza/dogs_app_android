package com.isczaragoza.dogsapp.data.dataSources

import com.isczaragoza.dogsapp.data.database.DogDatabaseClient
import com.isczaragoza.dogsapp.domain.entities.DogEntity
import kotlinx.coroutines.flow.Flow

class DogLocalDataSource(private val dogDatabaseClient: DogDatabaseClient) {
    suspend fun insertListOfDogs(listOfDogs: List<DogEntity>) {
        dogDatabaseClient.insertListOfDogs(listOfDogs)
    }

    fun getListOfDogs(): Flow<List<DogEntity>> {
        return dogDatabaseClient.getListOfDogs()
    }
}