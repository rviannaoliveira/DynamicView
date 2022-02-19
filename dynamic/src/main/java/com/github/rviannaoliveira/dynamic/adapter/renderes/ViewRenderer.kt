package com.github.rviannaoliveira.dynamic.adapter.renderes

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.rviannaoliveira.dynamic.domain.model.DynamicActionProperties
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties

abstract class ViewRenderer<VH : RecyclerView.ViewHolder>(val key: String, val viewType: Int) {
    abstract var onClickListener: DynamicViewListener?
    abstract fun bindView(model: SimpleProperties, holder: VH, position: Int)
    abstract fun createViewHolder(parent: ViewGroup): VH
}

typealias DynamicViewListener = ((DynamicActionProperties) -> Unit)
