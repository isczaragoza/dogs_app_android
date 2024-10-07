package com.isczaragoza.dogsapp.listOfDogs

import com.isczaragoza.dogsapp.framework.models.DogUiModel

data class ListOfDogsState(
    val isLoading: Boolean,
    val listOfDogs: List<DogUiModel> = emptyList(),
    val error: String
)
