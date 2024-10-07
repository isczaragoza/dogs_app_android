package com.isczaragoza.dogsapp.domain.di

import com.isczaragoza.dogsapp.domain.useCases.GetListOfDogsUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    //Use Cases
    factoryOf(::GetListOfDogsUseCase)
}