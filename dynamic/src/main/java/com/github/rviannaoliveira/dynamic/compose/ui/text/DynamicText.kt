package com.github.rviannaoliveira.dynamic.compose.ui.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import com.github.rviannaoliveira.dynamic.compose.ui.getTextAlignCompose
import com.github.rviannaoliveira.dynamic.compose.ui.getTextStyleCompose
import com.github.rviannaoliveira.dynamic.core.data.model.text.TextProperties
import com.github.rviannaoliveira.dynamic.core.extensions.empty
import com.github.rviannaoliveira.dynamic.xml.ui.button.parseColorCompose

@Composable
fun DynamicText(
    textProperties: TextProperties,
    clickable: (() -> Unit?)? = null
) {
    val modifier = clickable?.let {
        Modifier.clickable {
            clickable.invoke()
        }
    } ?: Modifier

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = textProperties.backgroundHex.parseColorCompose()
    ) {
        Text(
            modifier = modifier,
            style = getTextStyleCompose(textProperties.textStyle).copy(
                fontSize = textProperties.textSize?.toFloat()?.sp ?: TextUnit.Unspecified,
            ),
            text = textProperties.textHtml?.let { html ->
                HtmlCompat.fromHtml(
                    html, HtmlCompat.FROM_HTML_MODE_COMPACT
                ).toString()
            } ?: getText(textProperties),
            color = textProperties.textColorHex?.parseColorCompose() ?: Color.Unspecified,
            textAlign = getTextAlignCompose(textProperties.align),
        )
    }
}

private fun getText(textProperties: TextProperties) = when (textProperties.textAllCaps) {
    true -> textProperties.text?.uppercase()
    false -> textProperties.text?.lowercase()
    else -> textProperties.text
} ?: String.empty()
