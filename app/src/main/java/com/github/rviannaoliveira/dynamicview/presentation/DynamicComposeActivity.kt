package com.github.rviannaoliveira.dynamicview.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.lifecycle.lifecycleScope
import com.github.rviannaoliveira.dynamic.domain.mapper.convertToVO
import com.github.rviannaoliveira.dynamic.domain.model.DynamicActionProperties
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.github.rviannaoliveira.dynamic.presentation.builder.DynamicComposeBuilder
import com.github.rviannaoliveira.dynamic.presentation.render.renderes.DynamicViewListener
import com.github.rviannaoliveira.dynamicview.components.DynamicButtonCompose
import com.github.rviannaoliveira.dynamicview.components.DynamicTextCompose
import com.github.rviannaoliveira.dynamicview.components.TextProperties
import com.github.rviannaoliveira.dynamicview.data.DynamicRepositoryImpl
import com.google.gson.Gson
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class DynamicComposeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = DynamicRepositoryImpl(
            Gson(),
            this.baseContext
        )

        setContent {
            MaterialTheme {
                var properties = emptyList<SimpleProperties>()
                lifecycleScope.launch {
                    val getDynamic = repository.getDynamic()
                    properties = getDynamic.first()
                }
                val dynamicBuilder = DynamicBuilders()

                LazyColumn {
                    items(properties.size) { index ->
                        val model = properties[index]
                        val builder = dynamicBuilder.getBuilder(model.key)
                        builder.buildCompose(model = model) {
                            println(
                                ">>>> category ${it.analytics?.category} -" +
                                        " action ${it.analytics?.action} -" +
                                        " label  ${it.analytics?.label} -" +
                                        " deeplink ${it.deeplink}"
                            )
                        }
                    }
                }
            }
        }
    }
}
