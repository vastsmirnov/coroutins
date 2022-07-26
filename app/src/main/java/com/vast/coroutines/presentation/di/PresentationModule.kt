package com.vast.coroutines.presentation.di

import com.vast.coroutines.presentation.animals.list.AnimalListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        AnimalListViewModel(getAnimalListUseCase = get())
    }
}