package com.github.rviannaoliveira.dynamic.compose.presentation

import com.github.rviannaoliveira.dynamic.compose.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.compose.ui.button.DynamicButtonComposeRender
import com.github.rviannaoliveira.dynamic.compose.ui.empty.DynamicEmptyComposeRender
import com.github.rviannaoliveira.dynamic.compose.ui.text.DynamicTextComposeRender

class DynamicComposeBuilders {

    private val listDynamicBuilder: List<DynamicComposeBuilder> = listOf(
        DynamicButtonComposeRender(),
        DynamicTextComposeRender()
    )

    fun getBuilder(
        key: String, customDynamicBuilderList: List<DynamicComposeBuilder> = emptyList()
    ): DynamicComposeBuilder = (listDynamicBuilder + customDynamicBuilderList)
        .distinctBy { it.key }
        .find {
        it.key == key
    } ?: DynamicEmptyComposeRender()
}