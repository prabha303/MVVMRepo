package com.prabha.ui.launcher

import android.content.Context
import java.io.InputStream


object Util {

    fun readJSONFromAsset(context: Context): String? {
        var json: String? = null
        try {
            val  inputStream: InputStream = context.assets.open("data.json")
            json = inputStream.bufferedReader().use{it.readText()}
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}