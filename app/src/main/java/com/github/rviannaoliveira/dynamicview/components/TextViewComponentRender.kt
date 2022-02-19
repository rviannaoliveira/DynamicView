package com.github.rviannaoliveira.dynamicview.components

import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.rviannaoliveira.dynamic.presentation.renderes.DynamicViewListener
import com.github.rviannaoliveira.dynamic.presentation.renderes.ViewRenderer
import com.github.rviannaoliveira.dynamic.domain.mapper.convertToVO
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.github.rviannaoliveira.dynamicview.presentation.DynamicComponent

class TextViewComponentRender(override var onClickListener: DynamicViewListener?) : ViewRenderer<TextViewComponentRender.TextViewHolder>(DynamicComponent.TEXT_VIEW_COMPONENT.key, DynamicComponent.TEXT_VIEW_COMPONENT.ordinal) {

    inner class TextViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun bindView(model: SimpleProperties, holder: TextViewHolder, position: Int) {
        val textProperties = model.value.convertToVO<TextProperties>()
        holder.textView.text = textProperties.text
        holder.textView.textSize = 32f
        textProperties.textColor?.let { textColorHex ->
            holder.textView.setTextColor(textColorHex.parseColor())
        }
    }

    override fun createViewHolder(parent: ViewGroup): TextViewHolder {
        return TextViewHolder(TextView(parent.context))
    }
}