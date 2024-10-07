package com.isczaragoza.dogsapp.framework.databaseImpl

import com.isczaragoza.dogsapp.data.database.DogDatabaseClient
import com.isczaragoza.dogsapp.domain.entities.DogEntity
import kotlinx.coroutines.flow.Flow

class DogRoomDatabaseClient(private val dogsAppRoomDatabase: DogsAppRoomDatabase) :
    DogDatabaseClient {
    override suspend fun insertListOfDogs(listOfDogs: List<DogEntity>) {
        dogsAppRoomDatabase.dogDAO().insertListOfDogs(listOfDogs)
    }

    override fun getListOfDogs(): Flow<List<DogEntity>> {
        return dogsAppRoomDatabase.dogDAO().getListOfDogs()
    }
}