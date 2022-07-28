package com.vast.coroutines.domain.animals

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAnimalListUseCaseImpl(private val animalRepository: AnimalRepository): GetAnimalListUseCase {
    override suspend fun execute(): List<Animal> = withContext(Dispatchers.IO) {
        return@withContext animalRepository.getList()
    }
}