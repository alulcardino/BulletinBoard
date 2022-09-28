package com.rm.bulletinboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init();
    }

    private fun init() {
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState();
        navView.setNavigationItemSelectedListener (this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.id_my_ads -> {
                Toast.makeText(this, "ADS", Toast.LENGTH_LONG).show()
            }
            R.id.id_car-> {
                Toast.makeText(this, "car", Toast.LENGTH_LONG).show()

            }
            R.id.id_computer -> {
                Toast.makeText(this, "pc", Toast.LENGTH_LONG).show()

            }
            R.id.id_smartphone -> {
                Toast.makeText(this, "phone", Toast.LENGTH_LONG).show()

            }
            R.id.id_ha -> {
                Toast.makeText(this, "ha", Toast.LENGTH_LONG).show()

            }
            R.id.id_sign_up -> {
                Toast.makeText(this, "up", Toast.LENGTH_LONG).show()

            }
            R.id.id_log_in -> {
                Toast.makeText(this, "in", Toast.LENGTH_LONG).show()

            }
            R.id.id_exit -> {
                Toast.makeText(this, "exit", Toast.LENGTH_LONG).show()

            }
        }
        return true;
    }

}