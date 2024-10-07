package com.isczaragoza.dogsapp.domain.repositories

import com.isczaragoza.dogsapp.domain.entities.DogEntity
import kotlinx.coroutines.flow.Flow

interface DogRepository {
    fun getListOfDogs(): Flow<List<DogEntity>>
}