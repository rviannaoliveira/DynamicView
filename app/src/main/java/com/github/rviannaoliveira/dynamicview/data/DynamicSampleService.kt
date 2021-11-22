package com.github.rviannaoliveira.dynamicview.data

import com.github.rviannaoliveira.dynamic.data.DataSimplePropertiesResponse
import retrofit2.http.GET

interface DynamicSampleService {
    @GET("dynamic")
    suspend fun getDynamicExample() : DataSimplePropertiesResponse
}