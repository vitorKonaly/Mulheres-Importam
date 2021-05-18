package com.konaly.mulhersimportamofc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.konaly.mulhersimportamofc.networks.ApiClient
import com.konaly.mulhersimportamofc.request.LoginRequest
import com.konaly.mulhersimportamofc.response.LoginResponse
import com.konaly.mulhersimportamofc.shared.SessionManage
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    private lateinit var sessionManager: SessionManage
    private lateinit var apiClient: ApiClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
        irCadastro()
        logar()






    }

    private fun logar() {
        apiClient = ApiClient()
        sessionManager = SessionManage(this)

        btn_logar.setOnClickListener {
            apiClient.getApiService(this).login(LoginRequest(email = email_logar.text.toString(),password = senha_logar.text.toString()))
                .enqueue(object : Callback<LoginResponse>{
                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@Login,"REQUEST ERROR", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        Toast.makeText(this@Login,"Usuário logado com sucesso", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@Login,TelaInicial::class.java)
                        startActivity(intent)
                    }
                })
        }
    }

    private fun irCadastro() {

        textCadastrar.setOnClickListener {
            val intent = Intent(this,Cadastro::class.java)
            startActivity(intent)
        }

    }


}