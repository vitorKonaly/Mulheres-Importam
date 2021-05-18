package com.konaly.mulhersimportamofc.shared

import android.content.Context
import android.content.SharedPreferences
import com.konaly.mulhersimportamofc.R

class SessionManage(context: Context) {

    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
    }


    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }


    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
}