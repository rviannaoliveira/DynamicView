package com.github.rviannaoliveira.dynamicview.data

import com.github.rviannaoliveira.dynamic.domain.mapper.toListSimpleProperties
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface DynamicRepository {
    suspend fun getDynamic(): Flow<List<SimpleProperties>>
}

class DynamicRepositoryImpl(private val service: DynamicSampleService) : DynamicRepository {
    override suspend fun getDynamic(): Flow<List<SimpleProperties>> = flow{
        emit(service.getDynamicExample().data.toListSimpleProperties())
    }
}
