package com.isczaragoza.dogsapp.framework.databaseImpl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.isczaragoza.dogsapp.data.database.daos.DogDAO
import com.isczaragoza.dogsapp.domain.entities.DogEntity

@Database(
    entities = [DogEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DogsAppRoomDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "DogsAppRoomDatabase"
    }

    abstract fun dogDAO(): DogDAO
}