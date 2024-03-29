package com.github.rviannaoliveira.dynamic.compose.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.rviannaoliveira.dynamic.core.data.model.action.DynamicActionProperties
import com.github.rviannaoliveira.dynamic.core.data.model.base.SimpleProperties

@Composable
fun DynamicComposeController(
    properties: List<SimpleProperties>,
    modifier: Modifier = Modifier,
    onAction: (DynamicActionProperties) -> Unit
) {
    val dynamicBuilder = remember {
        DynamicComposeBuilders()
    }

    LazyColumn(
        modifier
    ) {
        items(
            count = properties.size,
          ) { index ->
            val model = properties[index]
            val builder = dynamicBuilder.getBuilder(model.key)
            builder.buildCompose(model = model) {
                onAction(it)
            }
        }
    }
}