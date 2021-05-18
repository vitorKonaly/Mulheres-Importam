package com.konaly.mulhersimportamofc.networks

import android.content.Context
import com.konaly.mulhersimportamofc.interceptor.AuthInterceptor
import com.konaly.mulhersimportamofc.utils.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private lateinit var apiService:MiAPI

    fun getApiService(context: Context):MiAPI{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient(context))
            .build()

        apiService = retrofit.create(MiAPI::class.java)

        return apiService
    }
    fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()
    }

}