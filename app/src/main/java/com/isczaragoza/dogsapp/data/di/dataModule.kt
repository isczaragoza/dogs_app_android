package com.isczaragoza.dogsapp.data.di

import com.isczaragoza.dogsapp.data.dataSources.DogLocalDataSource
import com.isczaragoza.dogsapp.data.dataSources.DogRemoteDataSource
import com.isczaragoza.dogsapp.data.repositoriesImpl.DogRepositoryImpl
import com.isczaragoza.dogsapp.domain.repositories.DogRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    //Repository
    factoryOf(::DogRepositoryImpl) { bind<DogRepository>() }
    //factoryOf(::DogRepositoryImpl) DSL
    //factory { DogRepositoryImpl(get()) as DogRepository } other Approach
    //Data Sources
    factoryOf(::DogRemoteDataSource) //DSL
    factory { DogLocalDataSource(get()) }
}