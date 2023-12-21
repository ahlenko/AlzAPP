package com.mycompany.alztestapp.logic.appmvp.login.response

import com.google.gson.annotations.SerializedName

data class ResultSessionKey(
    @SerializedName("session_token") val sessionToken: String
)
