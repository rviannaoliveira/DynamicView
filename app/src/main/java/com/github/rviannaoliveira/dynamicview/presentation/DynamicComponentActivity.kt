package com.github.rviannaoliveira.dynamicview.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.rviannaoliveira.dynamic.adapter.DynamicAdapter
import com.github.rviannaoliveira.dynamicview.databinding.ActivityDynamicComponentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DynamicComponentActivity : AppCompatActivity() {
    lateinit var binding: ActivityDynamicComponentBinding
    private val vm: DynamicViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recycler.adapter = vm.dynamic as DynamicAdapter
        lifecycle.addObserver(vm)

        vm.deeplink.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        vm.analytics.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}