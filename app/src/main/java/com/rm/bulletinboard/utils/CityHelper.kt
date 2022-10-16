package com.rm.bulletinboard.utils

import android.content.Context
import android.util.Log
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

object CityHelper {
    fun getAllCountries(context: Context): ArrayList<String> {
        var tempArray = ArrayList<String>()
        try {
            val inputStream: InputStream = context.assets.open("cities.json")
            val size = inputStream.available()
            val byteArray = ByteArray(size)
            inputStream.read(byteArray)
            val jsonFile = String(byteArray)
            val jsonObject = JSONObject(jsonFile)
            val country  = jsonObject.names()
            if (country != null) {
                for (n in 0 until country.length())
                    tempArray.add(country.getString(n))
            }
        } catch (e: java.lang.Exception) {
            Log.d("MyLog", "kavo : $tempArray")
        }
        return tempArray
    }
}