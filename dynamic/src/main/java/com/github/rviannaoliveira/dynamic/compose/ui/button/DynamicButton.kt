package com.github.rviannaoliveira.dynamic.compose.ui.button

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import com.github.rviannaoliveira.dynamic.compose.ui.getArrangementCompose
import com.github.rviannaoliveira.dynamic.compose.ui.text.DynamicText
import com.github.rviannaoliveira.dynamic.core.data.model.button.ButtonProperties
import com.github.rviannaoliveira.dynamic.core.data.model.text.TextProperties

@Composable
fun DynamicButton(
    buttonProperties: ButtonProperties,
    clickable: () -> Unit
) {
    Row(
        horizontalArrangement = getArrangementCompose(buttonProperties.align)
    ) {
        Button(
            onClick = {
                clickable.invoke()
            },
        ) {
            DynamicText(
                textProperties = TextProperties(
                    text = buttonProperties.text,
                    align = buttonProperties.textAlign,
                    textAllCaps = buttonProperties.textAllCaps,
                    textColorHex = buttonProperties.textColorHex,
                    textSize = buttonProperties.textSize,
                )
            )
        }
    }
}