package com.isczaragoza.dogsapp.data.mappers

import com.isczaragoza.dogsapp.data.dtos.DogResponseDTO
import com.isczaragoza.dogsapp.domain.entities.DogEntity

fun DogResponseDTO.asDomainEntity(): DogEntity {
    return DogEntity(dogName = dogName, description = description, age = age, image = image)
}