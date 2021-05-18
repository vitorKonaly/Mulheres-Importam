package com.konaly.mulhersimportamofc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()

        textCadastrar.setOnClickListener {
            irCadastro()
        }
    }

    private fun irCadastro() {
        val intent = Intent(this,Cadastro::class.java)
        startActivity(intent)
    }


}