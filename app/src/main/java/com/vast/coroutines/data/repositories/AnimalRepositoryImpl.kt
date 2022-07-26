package com.vast.coroutines.data.repositories

import com.vast.coroutines.data.net.animals.AnimalService
import com.vast.coroutines.domain.animals.Animal
import com.vast.coroutines.domain.animals.AnimalRepository
import io.reactivex.Single

class AnimalRepositoryImpl(private val animalApiService: AnimalService) : AnimalRepository {
    override fun getList(): Single<List<Animal>> {
        return animalApiService.getList()
    }
}