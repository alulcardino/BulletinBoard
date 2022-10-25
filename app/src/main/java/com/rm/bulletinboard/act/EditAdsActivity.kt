package com.rm.bulletinboard.act

//noinspection SuspiciousImport\

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rm.bulletinboard.R
import com.rm.bulletinboard.databinding.ActivityEditAdsBinding
import com.rm.bulletinboard.dialogs.DialogSpinnerHelper
import com.rm.bulletinboard.utils.CityHelper
import com.rm.bulletinboard.utils.ImagePicker.options
import io.ak1.pix.helpers.PixEventCallback
import io.ak1.pix.helpers.addPixToActivity

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

    fun onClickSelectCountry(view: View) {
        val listCountry = CityHelper.getAllCountries(this)
        dialog.showSpinnerDialog(this, listCountry, rootElement.tvSelectCountry)
        if (rootElement.tvSelectCity.text.toString() != getString(R.string.select_city)) {
            rootElement.tvSelectCity.text = getString(R.string.select_city)
        }
    }


    fun onClickSelectCity(view: View) {
        val selectedCountry = rootElement.tvSelectCountry.text.toString()
        Log.d("My Log", "sho $selectedCountry")
        if (selectedCountry != getString(R.string.select_country)) {
            val listCity = CityHelper.getAllCities(this, selectedCountry)
            dialog.showSpinnerDialog(this, listCity, rootElement.tvSelectCity)
        } else {
            Toast.makeText(this, "No country selected", Toast.LENGTH_LONG).show()
        }
    }


    fun onClickGetImages(view: View) {
        addPixToActivity(R.id.activity_edit_ads, options) {
            when (it.status) {
                PixEventCallback.Status.SUCCESS -> {
                    Log.d("MyLog", it.data[0].toString())
                    Log.d("MyLog", it.data[1].toString())
                    Log.d("MyLog", it.data[2].toString())
                }
                PixEventCallback.Status.BACK_PRESSED -> super.onBackPressed()
            }
        }
    }

}