package com.github.rviannaoliveira.dynamic.xml.ui.button

import android.graphics.Color.parseColor
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.rviannaoliveira.dynamic.core.data.convertToVO
import com.github.rviannaoliveira.dynamic.core.data.model.base.SimpleProperties
import com.github.rviannaoliveira.dynamic.core.data.model.button.ButtonProperties
import com.github.rviannaoliveira.dynamic.core.presentation.DynamicComponent
import com.github.rviannaoliveira.dynamic.core.presentation.DynamicViewListener
import com.github.rviannaoliveira.dynamic.xml.presentation.ViewRenderer

class ButtonComponentRender(override var onClickListener: DynamicViewListener?) :
    ViewRenderer<ButtonComponentRender.ButtonHolder>(
        DynamicComponent.BUTTON_COMPONENT.key, DynamicComponent.BUTTON_COMPONENT.ordinal
    ) {

    inner class ButtonHolder(val button: ButtonComponent) : RecyclerView.ViewHolder(button)

    override fun bindView(model: SimpleProperties, holder: ButtonHolder, position: Int) {
        val buttonProperties = model.value.convertToVO<ButtonProperties>()

        holder.button.setProperties(buttonProperties)
        buttonProperties.actionProperties?.let { actionProperties ->
            holder.button.setOnClickListener {
                onClickListener?.invoke(actionProperties)
            }
        }
    }

    override fun createViewHolder(parent: ViewGroup): ButtonHolder {
        return ButtonHolder(ButtonComponent(parent.context))
    }
}

internal fun String.parseColor(): Int {
    return try {
        parseColor(this)
    } catch (ex: Exception) {
        0
    }
}
