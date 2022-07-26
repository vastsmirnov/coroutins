package com.vast.coroutines.domain.animals

import io.reactivex.Single

interface GetAnimalListUseCase {
    fun execute(): Single<List<Animal>>
}