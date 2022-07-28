package com.vast.coroutines.domain.animals

interface AnimalRepository {
    suspend fun getList(): List<Animal>
}