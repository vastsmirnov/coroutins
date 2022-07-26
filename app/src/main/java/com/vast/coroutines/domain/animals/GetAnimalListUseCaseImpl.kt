package com.vast.coroutines.domain.animals

import io.reactivex.Single

class GetAnimalListUseCaseImpl(private val animalRepository: AnimalRepository): GetAnimalListUseCase {
    override fun execute(): Single<List<Animal>> {
        return animalRepository.getList()
    }
}