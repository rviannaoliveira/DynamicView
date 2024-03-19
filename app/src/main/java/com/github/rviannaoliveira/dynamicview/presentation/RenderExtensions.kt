package com.github.rviannaoliveira.dynamicview.presentation

import com.github.rviannaoliveira.dynamic.core.data.model.base.SimpleProperties
import com.github.rviannaoliveira.dynamic.core.presentation.DynamicComponent
import com.github.rviannaoliveira.dynamic.core.presentation.DynamicViewListener
import com.github.rviannaoliveira.dynamic.xml.presentation.ViewRenderer
import com.github.rviannaoliveira.dynamic.xml.ui.button.ButtonComponentRender
import com.github.rviannaoliveira.dynamic.xml.ui.text.TextViewComponentRender

fun List<SimpleProperties>.toRenders(listener : DynamicViewListener): List<ViewRenderer<*>> {
    return this
        .distinctBy { it.key }
        .mapNotNull { simpleProperties ->
            val key = simpleProperties.key
            when (DynamicComponent.values().find { it.key == key }) {
                DynamicComponent.TEXT_VIEW_COMPONENT -> TextViewComponentRender(listener)
                DynamicComponent.BUTTON_COMPONENT -> ButtonComponentRender(listener)
                else -> null
            }
        }
}
