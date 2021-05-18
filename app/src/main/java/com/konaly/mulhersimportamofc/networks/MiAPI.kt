package com.konaly.mulhersimportamofc.networks

import com.konaly.mulhersimportamofc.models.Produto
import com.konaly.mulhersimportamofc.request.LoginRequest
import com.konaly.mulhersimportamofc.response.LoginResponse
import com.konaly.mulhersimportamofc.utils.Constants.Companion.LOGIN_URL
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MiAPI {
    @POST(LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("produtos")
    fun getProdutos():Call<Produto>


}