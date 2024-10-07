package com.isczaragoza.dogsapp.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DogEntity(
    @PrimaryKey
    val dogName: String,
    val description: String?,
    val age: Int?,
    val image: String?
)
