package com.github.rviannaoliveira.dynamic.xml.ui.button

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.github.rviannaoliveira.dynamic.core.data.model.button.ButtonProperties
import com.github.rviannaoliveira.dynamic.core.domain.Align
import com.github.rviannaoliveira.dynamic.core.extensions.getAttrColorRes

class ButtonComponent @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatButton(context, attrs, defStyleAttr) {

    fun setProperties(buttonProperties: ButtonProperties) {
        buttonProperties.text?.let { text ->
            setText(text)
        }

        buttonProperties.textColorHex?.let { textColorHex ->
            setTextColor(textColorHex.parseColor())
        }

//TODO Fix Bug
//        buttonProperties.backgroundHex?.let { backgroundHex ->
//            backgroundTintList = ColorStateList.valueOf(backgroundHex.parseColor())
//        } ?: run {
//            backgroundTintList = ColorStateList.valueOf(
//                ContextCompat.getColor(
//                    context,
//                    context.getAttrColorRes(android.R.attr.colorPrimary)
//                )
//            )
//        }


        buttonProperties.textAllCaps?.let { isTextAllCaps ->
            isAllCaps = isTextAllCaps
        }

        buttonProperties.textSize?.let { size ->
            setTextSize(TypedValue.COMPLEX_UNIT_SP, size.toFloat())
        }

        buttonProperties.align.toGravity()
    }

    private fun Align?.toGravity() = when (this) {
        Align.CENTER -> {
            gravity = Gravity.CENTER
        }

        Align.RIGHT -> {
            gravity = Gravity.RIGHT
        }

        else -> gravity = Gravity.LEFT
    }
}