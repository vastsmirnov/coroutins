package com.vast.coroutines.data.net.animals

import com.vast.coroutines.domain.animals.Animal
import io.reactivex.Single
import retrofit2.http.GET

interface AnimalService {
    @GET("./animals/rand/10")
    fun getList(): Single<List<Animal>>
}