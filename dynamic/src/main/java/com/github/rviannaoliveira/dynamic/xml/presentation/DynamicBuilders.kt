package com.github.rviannaoliveira.dynamic.xml.presentation

import com.github.rviannaoliveira.dynamic.core.data.model.base.SimpleProperties
import com.github.rviannaoliveira.dynamic.core.presentation.DynamicViewListener
import com.github.rviannaoliveira.dynamic.xml.ui.button.ButtonComponentRender
import com.github.rviannaoliveira.dynamic.xml.ui.text.TextViewComponentRender

class DynamicBuilders {
    fun getBuilderRenders(
        simpleProperties: List<SimpleProperties>,
        customDynamicBuilderList: List<ViewRenderer<*>> = emptyList(),
        onAction: DynamicViewListener
    ): List<ViewRenderer<*>> {
        val allViewRenders = (customDynamicBuilderList + listOf(
            TextViewComponentRender(onAction),
            ButtonComponentRender(onAction)
        ))

        return simpleProperties.distinctBy { it.key }.mapNotNull { simpleProperties ->
                val key = simpleProperties.key
                allViewRenders.find {
                    it.key == key
                }
            }
    }
}