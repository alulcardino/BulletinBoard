package com.rm.bulletinboard.utils

import android.content.Context
import android.util.Log
import com.rm.bulletinboard.R
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.util.*
import kotlin.collections.ArrayList


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

    fun getAllCities(context: Context, country: String): ArrayList<String> {
        var tempArray = ArrayList<String>()
        try {
            val inputStream: InputStream = context.assets.open("cities.json")
            val size = inputStream.available()
            val byteArray = ByteArray(size)
            inputStream.read(byteArray)
            val jsonFile = String(byteArray)
            val jsonObject = JSONObject(jsonFile)
            val city  = jsonObject.getJSONArray(country)
            if (city != null) {
                for (n in 0 until city.length())
                    tempArray.add(city.getString(n))
            }
        } catch (e: java.lang.Exception) {
            Log.d("MyLog", "kavo : $tempArray")
        }
        return tempArray
    }

    fun filetListData(list : ArrayList<String>, searchText : String?) : ArrayList<String> {
        val tempList = ArrayList<String>()
        tempList.clear()
        if (searchText == null) {
            tempList.add(R.string.no_result.toString())
            return tempList
        }
        for (selection : String in list) {
            if (selection.lowercase(Locale.ROOT).startsWith(searchText.lowercase(Locale.ROOT))) {
                Log.d("MyLog", "sho : $tempList")
                tempList.add(selection)
            }
        }
        if (tempList.size == 0) {
            tempList.add(R.string.no_result.toString())
        }
        Log.d("MyLog", "kavo : $tempList")

        return tempList
    }
}