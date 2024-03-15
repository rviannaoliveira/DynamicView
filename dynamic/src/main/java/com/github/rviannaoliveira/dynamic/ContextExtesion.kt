package com.github.rviannaoliveira.dynamic

import android.content.Context

fun Context.loadJSONFromAsset(fileName: String): String =
    assets.open("$fileName.json").bufferedReader().use {
        it.readText()
    }
