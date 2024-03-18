package com.github.rviannaoliveira.dynamic.presentation.builder

import androidx.compose.runtime.Composable
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.github.rviannaoliveira.dynamic.presentation.render.renderes.DynamicViewListener

abstract class DynamicComposeBuilder(val key: String) {
    @Composable
    abstract fun buildCompose(model: SimpleProperties, listener: DynamicViewListener)
}