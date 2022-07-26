package com.vast.coroutines.domain.di

import com.vast.coroutines.domain.animals.GetAnimalListUseCase
import com.vast.coroutines.domain.animals.GetAnimalListUseCaseImpl
import org.koin.dsl.module

val domainModule = module {
    single<GetAnimalListUseCase> {
        GetAnimalListUseCaseImpl(animalRepository = get())
    }
}