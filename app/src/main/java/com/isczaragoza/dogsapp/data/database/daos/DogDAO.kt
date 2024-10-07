package com.isczaragoza.dogsapp.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.isczaragoza.dogsapp.domain.entities.DogEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface DogDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListOfDogs(listOfDogsDTO: List<DogEntity>)

    @Query("SELECT * FROM DogEntity LIMIT 150")
    fun getListOfDogs(): Flow<List<DogEntity>>
}