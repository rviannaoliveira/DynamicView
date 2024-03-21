package com.github.rviannaoliveira.dynamicview.compose.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import com.github.rviannaoliveira.dynamic.compose.presentation.DynamicComposeController

@Composable
fun InitialScreen(
    vm: DynamicComposeViewModel
) {
    val properties by vm.properties.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.loadProperties()
    }

    DynamicComposeController(
        properties = properties
    ) {
        println(
            ">>>> category ${it.analytics?.category} -" + " action ${it.analytics?.action} -" + " label  ${it.analytics?.label} -" + " deeplink ${it.deeplink}"
        )
    }
}