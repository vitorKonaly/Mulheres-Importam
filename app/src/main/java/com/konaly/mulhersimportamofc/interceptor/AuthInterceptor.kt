package com.konaly.mulhersimportamofc.interceptor

import android.content.Context
import com.konaly.mulhersimportamofc.shared.SessionManage
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context):Interceptor {
    private val sessionManager = SessionManage(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        sessionManager.fetchAuthToken()?.let {
            requestBuilder.addHeader("Authorization", "Bearer $it")

        }
        return chain.proceed(requestBuilder.build())
    }
}