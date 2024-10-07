package com.isczaragoza.dogsapp.domain.useCases

import com.isczaragoza.dogsapp.domain.entities.DogEntity
import com.isczaragoza.dogsapp.domain.enums.DatabaseError
import com.isczaragoza.dogsapp.domain.enums.NetworkError
import com.isczaragoza.dogsapp.domain.repositories.DogRepository
import com.isczaragoza.dogsapp.domain.resultHandler.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class GetListOfDogsUseCase(private val dogRepository: DogRepository) {
    operator fun invoke(): Flow<Result<List<DogEntity>>> {
        return dogRepository.getListOfDogs().map {
            Result.Success(it) as Result<List<DogEntity>>
        }.catch {
            println("Catch ${it.message}")
            println("Catch ${it.cause}")
            println("Catch ${it.stackTrace}")
            println("Catch ${it.localizedMessage}")
            when (it.message?.lowercase()) {
                NetworkError.TIME_OUT.message.lowercase() -> {
                    emit(Result.Error(NetworkError.TIME_OUT))
                }

                NetworkError.NO_NETWORK_CONNECTION.message.lowercase() -> {
                    emit(Result.Error(NetworkError.NO_NETWORK_CONNECTION))
                }

                DatabaseError.INSERT_ERROR.message.lowercase() -> {
                    emit(Result.Error(DatabaseError.INSERT_ERROR))
                }

                DatabaseError.GET_ERROR.message.lowercase() -> {
                    emit(Result.Error(DatabaseError.GET_ERROR))
                }

                else -> {
                    emit(Result.Error(NetworkError.UNKNOWN_ERROR))
                }
            }
        }
    }
}