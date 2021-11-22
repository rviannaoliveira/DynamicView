package com.github.rviannaoliveira.dynamicview.components

import android.graphics.Color
import android.graphics.Color.parseColor
import android.graphics.PorterDuff
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.github.rviannaoliveira.dynamic.adapter.renderes.DynamicViewListener
import com.github.rviannaoliveira.dynamic.adapter.renderes.ViewRenderer
import com.github.rviannaoliveira.dynamic.domain.mapper.convertToVO
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.github.rviannaoliveira.dynamicview.presentation.DynamicComponent

class ButtonComponentRender(override var onClickListener: DynamicViewListener?)
    : ViewRenderer<ButtonComponentRender.ButtonHolder>(DynamicComponent.BUTTON_COMPONENT.key, DynamicComponent.BUTTON_COMPONENT.ordinal) {

    inner class ButtonHolder(val button: Button) : RecyclerView.ViewHolder(button)

    override fun bindView(model: SimpleProperties, holder: ButtonHolder, position: Int) {
        val buttonProperties = model.value.convertToVO<ButtonProperties>()

        holder.button.text = buttonProperties.text
        holder.button.setTextColor(Color.WHITE)
        buttonProperties.textColorHex?.let { textColorHex ->
            holder.button.background.setColorFilter(textColorHex.parseColor(), PorterDuff.Mode.SRC_IN)
        }
        buttonProperties.actionProperties?.let { actionProperties ->
            holder.button.setOnClickListener {
                onClickListener?.invoke(actionProperties)
            }
        }
    }

    override fun createViewHolder(parent: ViewGroup): ButtonHolder {
        return ButtonHolder(Button(parent.context))
    }
}

internal fun String.parseColor(): Int {
    return try {
        parseColor(this)
    } catch (ex: Exception) {
        0
    }
}
