package com.isczaragoza.dogsapp.listOfDogs

import com.isczaragoza.dogsapp.domain.enums.BaseError
import com.isczaragoza.dogsapp.framework.models.DogUiModel

sealed interface ListOfDogsUiState {
    data object Loading : ListOfDogsUiState
    data class LoadFailed(val error: BaseError) : ListOfDogsUiState
    data class Success(val listOfDogs: List<DogUiModel>) : ListOfDogsUiState
}