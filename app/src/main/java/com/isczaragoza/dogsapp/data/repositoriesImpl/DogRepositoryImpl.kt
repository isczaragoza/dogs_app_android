package com.isczaragoza.dogsapp.data.repositoriesImpl

import com.isczaragoza.dogsapp.data.dataSources.DogLocalDataSource
import com.isczaragoza.dogsapp.data.dataSources.DogRemoteDataSource
import com.isczaragoza.dogsapp.domain.repositories.DogRepository
import com.isczaragoza.dogsapp.data.dtos.DogResponseDTO
import com.isczaragoza.dogsapp.data.mappers.asDomainEntity
import com.isczaragoza.dogsapp.domain.entities.DogEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn

class DogRepositoryImpl(
    private val dogRemoteDataSource: DogRemoteDataSource,
    private val dogLocalDataSource: DogLocalDataSource
) : DogRepository {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getListOfDogs(): Flow<List<DogEntity>> {
        return dogLocalDataSource.getListOfDogs().distinctUntilChanged()
            .flatMapLatest { listOfDogEntity ->
                if (listOfDogEntity.isNotEmpty()) {
                    return@flatMapLatest flowOf(listOfDogEntity)
                }
                val networkResult = dogRemoteDataSource.requestListOfDogs()
                var resultToEntity = emptyList<DogEntity>()
                if (!networkResult.isNullOrEmpty()) {
                    resultToEntity = networkResult.map { dogResponseDTO ->
                        dogResponseDTO.asDomainEntity()
                    }
                    dogLocalDataSource.insertListOfDogs(resultToEntity)
                }
                flowOf(resultToEntity)
            }.flowOn(Dispatchers.IO)
    }
}