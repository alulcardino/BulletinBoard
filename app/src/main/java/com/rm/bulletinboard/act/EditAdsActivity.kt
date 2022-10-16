package com.rm.bulletinboard.act

//noinspection SuspiciousImport
import android.R
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.rm.bulletinboard.databinding.ActivityEditAdsBinding
import com.rm.bulletinboard.utils.CityHelper

class EditAdsActivity : AppCompatActivity() {
    private lateinit var rootElement: ActivityEditAdsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityEditAdsBinding.inflate(layoutInflater)
        setContentView(rootElement.root)
        try {
            val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, CityHelper.getAllCountries(this))
            adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            rootElement.spCountry.adapter = adapter
        } catch (e: java.lang.Exception) {
            Log.d("MyLog", "blyat : ${e.message}")
        }
    }
}