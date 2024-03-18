package com.github.rviannaoliveira.dynamicview.components

import androidx.compose.runtime.Composable
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.github.rviannaoliveira.dynamic.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.presentation.render.renderes.DynamicViewListener

class DynamicEmptyCompose : DynamicComposeBuilder(
    ""
) {
    @Composable
    override fun buildCompose(model: SimpleProperties, listener: DynamicViewListener) {
    }
}