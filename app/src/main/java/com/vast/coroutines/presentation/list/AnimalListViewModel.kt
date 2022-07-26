package com.vast.coroutines.presentation.animals.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vast.coroutines.domain.animals.Animal
import com.vast.coroutines.domain.animals.GetAnimalListUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AnimalListViewModel(private val getAnimalListUseCase: GetAnimalListUseCase) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    private val _animalListLiveData = MutableLiveData<List<Animal>>()

    val animalListLiveData = _animalListLiveData as LiveData<List<Animal>>

    init {
       load()
    }

    private fun load() {
        compositeDisposable.add(
            getAnimalListUseCase.execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _animalListLiveData.value = it
                }, {
                    Log.d("aaa", it.toString())
                    _animalListLiveData.value = emptyList()
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}