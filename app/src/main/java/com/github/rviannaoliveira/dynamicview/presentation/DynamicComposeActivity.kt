package com.github.rviannaoliveira.dynamicview.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.lifecycleScope
import com.github.rviannaoliveira.dynamic.compose.presentation.DynamicBuilders
import com.github.rviannaoliveira.dynamic.core.data.model.base.SimpleProperties
import com.github.rviannaoliveira.dynamicview.data.DynamicRepositoryImpl
import com.google.gson.Gson
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
                var properties = remember {
                    emptyList<SimpleProperties>()
                }
                LaunchedEffect(Unit) {
                    val getDynamic = repository.getDynamic()
                    properties = getDynamic.first()
                }
                val dynamicBuilder = DynamicBuilders()

                LazyColumn {
                    items(properties.size) { index ->
                        val model = properties[index]
                        val builder = remember {
                            dynamicBuilder.getBuilder(model.key)
                        }
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
