package com.example.moviesstore.data.files

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import java.io.IOException
import java.lang.reflect.Type


fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    return try {
        context.assets.open(fileName).bufferedReader().use { it.readText() }

    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
}

fun getData(context: Context, fileName: String, type: Type): List<*> {
    val jsonFileString = getJsonDataFromAsset(context, fileName)
    Log.i("dataFromJson", jsonFileString ?: "Error")
    return Gson().fromJson(jsonFileString, type)
}

//val blocks = getData(
//    context, fileName, object : TypeToken<List<ArucoInfo>>() {}.type
//) as List<ArucoInfo>

