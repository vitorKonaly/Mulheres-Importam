package com.konaly.mulhersimportamofc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_cadastro.*

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        supportActionBar!!.hide()

        irLogin()
    }

    private fun irLogin() {

        textEntrar.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }


    }
}