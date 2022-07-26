package com.vast.coroutines.data.di

import com.vast.coroutines.data.repositories.AnimalRepositoryImpl
import com.vast.coroutines.domain.animals.AnimalRepository
import org.koin.dsl.module

val dataModule = module {
    single<AnimalRepository> {
        AnimalRepositoryImpl(animalApiService = get())
    }
}