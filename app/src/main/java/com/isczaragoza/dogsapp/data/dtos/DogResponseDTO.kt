package com.isczaragoza.dogsapp.data.dtos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DogResponseDTO(
    @SerialName("dogName") val dogName: String,
    @SerialName("description") val description: String?,
    @SerialName("age") val age: Int?,
    @SerialName("image") val image: String?
)
