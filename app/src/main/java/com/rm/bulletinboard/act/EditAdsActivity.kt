package com.rm.bulletinboard.act

//noinspection SuspiciousImport\
import com.rm.bulletinboard.R
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.rm.bulletinboard.databinding.ActivityEditAdsBinding
import com.rm.bulletinboard.dialogs.DialogSpinnerHelper
import com.rm.bulletinboard.utils.CityHelper

class EditAdsActivity : AppCompatActivity() {
    lateinit var rootElement: ActivityEditAdsBinding
    private var dialog = DialogSpinnerHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityEditAdsBinding.inflate(layoutInflater)
        setContentView(rootElement.root)
        init()
    }

    private fun init() {
    }

    fun onClickSelectCountry(view : View) {
        val listCountry = CityHelper.getAllCountries(this)
        dialog.showSpinnerDialog(this, listCountry, rootElement.tvSelectCountry)
        if (rootElement.tvSelectCity.text.toString() != getString(R.string.select_city)) {
            rootElement.tvSelectCity.text = getString(R.string.select_city)
        }
    }

    fun onClickSelectCity(view : View) {
        val selectedCountry = rootElement.tvSelectCountry.text.toString()
        Log.d("My Log", "sho $selectedCountry")
        if (selectedCountry != getString(R.string.select_country)) {
            val listCity = CityHelper.getAllCities(this,selectedCountry)
            dialog.showSpinnerDialog(this, listCity, rootElement.tvSelectCity)
        } else {
            Toast.makeText(this, "No country selected", Toast.LENGTH_LONG).show()
        }

    }
}