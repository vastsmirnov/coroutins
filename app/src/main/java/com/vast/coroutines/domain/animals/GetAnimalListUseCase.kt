package com.vast.coroutines.domain.animals

interface GetAnimalListUseCase {
    suspend fun execute(): List<Animal>
}