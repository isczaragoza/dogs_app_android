package com.isczaragoza.dogsapp.framework.di

import androidx.room.Room
import com.isczaragoza.dogsapp.data.database.DogDatabaseClient
import com.isczaragoza.dogsapp.data.network.DogApiClient
import com.isczaragoza.dogsapp.data.network.HttpClientProvider
import com.isczaragoza.dogsapp.framework.databaseImpl.DogsAppRoomDatabase
import com.isczaragoza.dogsapp.framework.databaseImpl.DogRoomDatabaseClient
import com.isczaragoza.dogsapp.framework.networkImpl.DogRetrofitApiClientImp
import com.isczaragoza.dogsapp.framework.networkImpl.RetrofitClientProvider
import com.isczaragoza.dogsapp.home.HomeScreenViewModel
import com.isczaragoza.dogsapp.listOfDogs.ListOfDogsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit

val frameworkModule = module {
    //Http Provider
    single { RetrofitClientProvider() as HttpClientProvider }
    //singleOf(::RetrofitClientProvider)
    //Retrofit Impl
    single { (get() as HttpClientProvider).provideHttpClient() as Retrofit }
    //Api Clients
    factory { DogRetrofitApiClientImp(get()) as DogApiClient }
    //Room Database "este es otro enfoque para injectar directamente la depencia de Room a diferencia de Retrofit"
    single {
        Room.databaseBuilder(
            androidApplication(),
            DogsAppRoomDatabase::class.java,
            DogsAppRoomDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
    //Database Clients
    factoryOf(::DogRoomDatabaseClient) { bind<DogDatabaseClient>() }
    //ViewModels
    viewModelOf(::HomeScreenViewModel)//DSL
    viewModel { ListOfDogsViewModel(get()) }
}