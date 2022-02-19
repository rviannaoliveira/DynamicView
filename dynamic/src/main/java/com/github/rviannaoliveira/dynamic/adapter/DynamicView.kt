package com.github.rviannaoliveira.dynamic.adapter

import com.github.rviannaoliveira.dynamic.adapter.renderes.ViewRenderer
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties

interface DynamicView {
    fun registerRenderer(renderer: ViewRenderer<*>)
    fun registerRenderers(renderers: List<ViewRenderer<*>>)
    fun setViewObjectDiff(properties: List<SimpleProperties>)
    fun updateViewAt(properties: SimpleProperties, index: Int)
    fun notifyPositionRemovedAt(position: Int)
    fun notifyItemChangeAt(position: Int, payload: Any? = null)
    fun clear()
}
