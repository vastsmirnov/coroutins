package com.vast.coroutines.presentation.animals.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vast.coroutines.domain.animals.Animal
import com.vast.coroutines.domain.animals.GetAnimalListUseCase
import kotlinx.coroutines.launch

class AnimalListViewModel(private val getAnimalListUseCase: GetAnimalListUseCase) : ViewModel() {
    private val _animalListLiveData = MutableLiveData<List<Animal>>()

    val animalListLiveData = _animalListLiveData as LiveData<List<Animal>>

    init {
       load()
    }

    private fun load() {
        viewModelScope.launch {
            _animalListLiveData.value = getAnimalListUseCase.execute()
        }
    }
}