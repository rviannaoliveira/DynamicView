package com.github.rviannaoliveira.dynamic.domain.mapper

import com.github.rviannaoliveira.dynamic.data.SimplePropertiesResponse
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.fasterxml.jackson.databind.ObjectMapper

inline fun <reified T : Any> Any?.convertToVO(): T =
        ObjectMapper().convertValue(this, T::class.java) as T

fun List<SimplePropertiesResponse>.toListSimpleProperties() = this.map {
    it.toSimpleProperties()
}

fun SimplePropertiesResponse.toSimpleProperties() =
        SimpleProperties(
                key = this.key,
                value = this.value
        )
