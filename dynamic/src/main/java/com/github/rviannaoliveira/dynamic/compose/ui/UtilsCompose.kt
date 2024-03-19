package com.github.rviannaoliveira.dynamic.compose.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.github.rviannaoliveira.dynamic.core.domain.Align
import com.github.rviannaoliveira.dynamic.core.domain.DynamicTextStyle

internal fun getTextStyleCompose(textStyle: DynamicTextStyle?) = when (textStyle) {
    DynamicTextStyle.BOLD -> TextStyle(fontWeight = FontWeight.Bold)
    DynamicTextStyle.ITALIC -> TextStyle(fontStyle = FontStyle.Italic)
    else -> TextStyle()
}

internal fun getTextAlignCompose(align: Align?) = when (align) {
    Align.CENTER -> TextAlign.Center
    Align.LEFT -> TextAlign.Left
    Align.RIGHT -> TextAlign.Right
    else -> null

}
internal fun getArrangementCompose(align: Align?) : Arrangement.Horizontal = when (align) {
    Align.CENTER -> Arrangement.Center
    Align.RIGHT -> Arrangement.Start
    else -> Arrangement.End
}