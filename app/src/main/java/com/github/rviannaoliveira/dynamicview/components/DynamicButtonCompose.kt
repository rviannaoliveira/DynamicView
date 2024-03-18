package com.github.rviannaoliveira.dynamicview.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.github.rviannaoliveira.dynamic.domain.mapper.convertToVO
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.github.rviannaoliveira.dynamic.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.presentation.render.renderes.DynamicViewListener
import com.github.rviannaoliveira.dynamicview.presentation.DynamicComponent

class DynamicButtonCompose : DynamicComposeBuilder(
    DynamicComponent.BUTTON_COMPONENT.key
) {
    @Composable
    override fun buildCompose(model: SimpleProperties, listener: DynamicViewListener) {
        val buttonProperties = model.value.convertToVO<ButtonProperties>()

        Button(onClick = {
            buttonProperties.actionProperties?.let { listener.invoke(it) }
        }) {
            Text(text = buttonProperties.text)
        }
    }
}