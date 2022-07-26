package com.vast.coroutines.data.repositories

import com.vast.coroutines.data.net.animals.AnimalService
import com.vast.coroutines.domain.animals.Animal
import com.vast.coroutines.domain.animals.AnimalRepository

class AnimalRepositoryImpl(private val animalApiService: AnimalService) : AnimalRepository {
    override suspend fun getList(): List<Animal> {
        return animalApiService.getList()
    }
}