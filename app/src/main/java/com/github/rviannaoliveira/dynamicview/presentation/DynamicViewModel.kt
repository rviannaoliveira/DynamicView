package com.github.rviannaoliveira.dynamicview.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.rviannaoliveira.dynamic.presentation.DynamicView
import com.github.rviannaoliveira.dynamic.presentation.renderes.DynamicViewListener
import com.github.rviannaoliveira.dynamic.domain.model.DynamicActionProperties
import com.github.rviannaoliveira.dynamic.domain.model.SimpleProperties
import com.github.rviannaoliveira.dynamicview.data.DynamicRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DynamicViewModel(
    val dynamic: DynamicView,
    val repository: DynamicRepository
) : BaseViewModel() {
    private val _analytics = MutableLiveData<String>()
    val analytics: LiveData<String>
        get() = _analytics

    private val _deeplink = MutableLiveData<String>()
    val deeplink: LiveData<String>
        get() = _deeplink


    override fun onResume() {
        super.onResume()
        viewModelScope.launch {
            repository.getDynamic()
                .catch {
                    it.printStackTrace()
                }
                .collect {
                    setupDynamicRender(it)
                    dynamic.setViewObjectDiff(it)
                }
        }
    }

    private fun setupDynamicRender(list : List<SimpleProperties>) {
        dynamic.registerRenderers(list.toRenders {
            listener.invoke(it)
        })
    }

    private val listener = object : DynamicViewListener {
        override fun invoke(actionProperties: DynamicActionProperties) {
            actionProperties.analytics?.let {
                _analytics.value =
                    "categoria: ${it.category}, ação: ${it.action}, label: ${it.label}"
            }
            actionProperties.deeplink?.let {
                _deeplink.value = it
            }
        }
    }
}