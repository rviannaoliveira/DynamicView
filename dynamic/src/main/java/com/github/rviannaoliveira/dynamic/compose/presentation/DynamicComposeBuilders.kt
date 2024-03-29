package com.github.rviannaoliveira.dynamic.compose.presentation

import com.github.rviannaoliveira.dynamic.compose.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.compose.ui.button.DynamicButtonComposeRender
import com.github.rviannaoliveira.dynamic.compose.ui.empty.DynamicEmptyComposeRender
import com.github.rviannaoliveira.dynamic.compose.ui.text.DynamicTextComposeRender

class DynamicComposeBuilders {

    private val listDynamicBuilder = listOf(
        DynamicButtonComposeRender(),
        DynamicTextComposeRender()
    )

    private val customBuilders = mutableListOf<DynamicComposeBuilder>()

    fun addBuilderRenders(
        customDynamicBuilderList: List<DynamicComposeBuilder>
    ): DynamicComposeBuilders {
        customBuilders.addAll(customDynamicBuilderList)
        return this
    }
   fun addBuilderRender(
        dynamicComposeBuilder: DynamicComposeBuilder
    ): DynamicComposeBuilders {
        customBuilders.add(dynamicComposeBuilder)
        return this
    }

    fun getBuilder(
        key: String
    ): DynamicComposeBuilder = (listDynamicBuilder + customBuilders)
        .distinctBy { it.key }
        .find {
            it.key == key
        } ?: DynamicEmptyComposeRender()
}