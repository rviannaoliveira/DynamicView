package com.github.rviannaoliveira.dynamic.compose.presentation

import com.github.rviannaoliveira.dynamic.compose.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.compose.ui.button.DynamicButtonCompose
import com.github.rviannaoliveira.dynamic.compose.ui.empty.DynamicEmptyCompose
import com.github.rviannaoliveira.dynamic.compose.ui.text.DynamicTextCompose

class DynamicBuilders {
    private val listDynamicBuilder: List<DynamicComposeBuilder> = listOf(
        DynamicButtonCompose(), DynamicTextCompose()
    )

    fun getBuilder(
        key: String, customDynamicBuilderList: List<DynamicComposeBuilder> = emptyList()
    ): DynamicComposeBuilder = (listDynamicBuilder + customDynamicBuilderList).find {
        it.key == key
    } ?: DynamicEmptyCompose()

}