package com.github.rviannaoliveira.dynamicview.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.github.rviannaoliveira.dynamic.domain.mapper.convertToVO
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.github.rviannaoliveira.dynamic.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.presentation.render.renderes.DynamicViewListener
import com.github.rviannaoliveira.dynamicview.presentation.DynamicComponent

class DynamicTextCompose : DynamicComposeBuilder(
    DynamicComponent.TEXT_VIEW_COMPONENT.key
) {
    @Composable
    override fun buildCompose(model: SimpleProperties, listener: DynamicViewListener) {
        Text(text = model.value.convertToVO<TextProperties>().text)
    }
}