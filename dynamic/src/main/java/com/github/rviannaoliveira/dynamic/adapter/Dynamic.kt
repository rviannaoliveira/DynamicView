package com.github.rviannaoliveira.dynamic.adapter

import androidx.recyclerview.widget.RecyclerView
import com.github.rviannaoliveira.dynamic.adapter.renderes.ViewRenderer
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties

interface Dynamic {
    fun registerRenderer(renderer: ViewRenderer<*>)
    fun registerRenderers(renderers: List<ViewRenderer<*>>)
    fun getRenderer(viewType: Int): ViewRenderer<RecyclerView.ViewHolder>
    fun getRenderers(): List<ViewRenderer<RecyclerView.ViewHolder>>
    fun setViewObjectDiff(properties: List<SimpleProperties>)
    fun updateViewAt(properties: SimpleProperties, index: Int)
    fun notifyPositionRemovedAt(position: Int)
    fun notifyChanges(properties: List<SimpleProperties>)
    fun notifyItemChangeAt(position: Int, payload: Any)
    fun notifyItemChangeAt(position: Int)
    fun clear()
}
