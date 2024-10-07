package com.isczaragoza.dogsapp.data.network

interface HttpClientProvider {
    fun provideHttpClient(): Any
}