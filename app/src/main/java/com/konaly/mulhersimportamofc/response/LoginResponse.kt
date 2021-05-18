package com.konaly.mulhersimportamofc.response

data class LoginResponse (
    var access_token:String,
    var token_type:String,
    var expires_in:Int
)