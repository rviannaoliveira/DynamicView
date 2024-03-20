package com.github.rviannaoliveira.dynamic.compose.ui.empty

import androidx.compose.runtime.Composable
import com.github.rviannaoliveira.dynamic.core.data.model.base.SimpleProperties
import com.github.rviannaoliveira.dynamic.compose.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.core.presentation.DynamicViewListener

class DynamicEmptyComposeRender : DynamicComposeBuilder(
    key = ""
) {
    @Composable
    override fun buildCompose(model: SimpleProperties, listener: DynamicViewListener) {
    }
}