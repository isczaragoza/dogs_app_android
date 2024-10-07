package com.isczaragoza.dogsapp.framework.mappers

import com.isczaragoza.dogsapp.data.dtos.DogResponseDTO
import com.isczaragoza.dogsapp.domain.entities.DogEntity
import com.isczaragoza.dogsapp.framework.models.DogUiModel

fun DogEntity.asUiModel(): DogUiModel {
    return DogUiModel(dogName = dogName, description = description, age = age, image = image)
}