package com.github.rviannaoliveira.dynamicview.presentation

import com.github.rviannaoliveira.dynamic.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamicview.components.DynamicButtonCompose
import com.github.rviannaoliveira.dynamicview.components.DynamicEmptyCompose
import com.github.rviannaoliveira.dynamicview.components.DynamicTextCompose

class DynamicBuilders {
    private val listDynamicBuilder: List<DynamicComposeBuilder> = listOf(
        DynamicButtonCompose(),
        DynamicTextCompose()
    )

    fun getBuilder(key: String) : DynamicComposeBuilder = listDynamicBuilder.find {
        it.key == key
    } ?: DynamicEmptyCompose()

}