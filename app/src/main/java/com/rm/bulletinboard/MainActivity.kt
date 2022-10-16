package com.rm.bulletinboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.rm.bulletinboard.accounthelper.AccountConst
import com.rm.bulletinboard.act.EditAdsActivity
import com.rm.bulletinboard.databinding.ActivityMainBinding
import com.rm.bulletinboard.dialoghelper.DialogConst
import com.rm.bulletinboard.dialoghelper.DialogHelper


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var rootElement: ActivityMainBinding
    private lateinit var tvAccount: TextView


    private val dialogHelper = DialogHelper(this)
    val mAuth = FirebaseAuth.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootElement = ActivityMainBinding.inflate(layoutInflater)
        setContentView(rootElement.root);

        init()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == AccountConst.SIGN_IN_REQUEST_CODE) {
            Log.d("MyLog", "Sign In Result")
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                if (account != null) {
                    dialogHelper.acHelper.signInFirebaseWithGoogle(account.idToken!!)
                }
            } catch (e: ApiException) {
                Log.d("MyLog", "Api Error : ${e.message}")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == R.id.id_new_ads) {
                val i = Intent(this, EditAdsActivity::class.java)
                startActivity(i)
            }
        return super.onOptionsItemSelected(item)
    }

    private fun init() {
        setSupportActionBar(rootElement.mainContent.toolbar)
        val toggle = ActionBarDrawerToggle(this, rootElement.drawerLayout, rootElement.mainContent.toolbar, R.string.open, R.string.close)
        rootElement.drawerLayout.addDrawerListener(toggle)
        toggle.syncState();
        rootElement.navView.setNavigationItemSelectedListener(this)
        tvAccount = rootElement.navView.getHeaderView(0).findViewById(R.id.tvAccountEmail)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_my_ads -> {
                Toast.makeText(this, "ADS", Toast.LENGTH_LONG).show()
            }
            R.id.id_car -> {
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
                dialogHelper.createSignDialog(DialogConst.SIGN_UP_STATE)
            }
            R.id.id_log_in -> {
                dialogHelper.createSignDialog(DialogConst.LOG_IN_STATE)

            }
            R.id.id_sign_out -> {
                uiUpdate(null)
                mAuth.signOut()
                dialogHelper.acHelper.signOut()
            }

        }
        rootElement.drawerLayout.closeDrawer(GravityCompat.START)
        return true;
    }

    override fun onStart() {
        super.onStart()
        uiUpdate(mAuth.currentUser)
    }

    fun uiUpdate(user: FirebaseUser?) {
        tvAccount.text = if (user == null) {
            resources.getString(R.string.not_reg)
        } else {
            user.email
        }
    }

}