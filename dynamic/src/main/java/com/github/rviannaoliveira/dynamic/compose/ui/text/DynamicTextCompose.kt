package com.github.rviannaoliveira.dynamic.compose.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.github.rviannaoliveira.dynamic.compose.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.core.data.convertToVO
import com.github.rviannaoliveira.dynamic.core.data.model.base.SimpleProperties
import com.github.rviannaoliveira.dynamic.core.data.model.text.TextProperties
import com.github.rviannaoliveira.dynamic.core.extensions.empty
import com.github.rviannaoliveira.dynamic.core.presentation.DynamicComponent
import com.github.rviannaoliveira.dynamic.core.presentation.DynamicViewListener

class DynamicTextCompose : DynamicComposeBuilder(
    DynamicComponent.TEXT_VIEW_COMPONENT.key
) {
    @Composable
    override fun buildCompose(model: SimpleProperties, listener: DynamicViewListener) {
        Text(text = model.value.convertToVO<TextProperties>().text ?: String.empty())
    }
}