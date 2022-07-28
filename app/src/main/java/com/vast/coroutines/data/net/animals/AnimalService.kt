package com.vast.coroutines.data.net.animals

import com.vast.coroutines.domain.animals.Animal
import retrofit2.http.GET

interface AnimalService {
    @GET("./animals/rand/10")
    suspend fun getList(): List<Animal>
}