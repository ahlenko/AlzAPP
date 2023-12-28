package com.mycompany.alztestapp.logic.shared_preference

import android.content.Context
import android.content.SharedPreferences

class SessionManager (context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(KEY_SHARED_PRP_NAME, Context.MODE_PRIVATE)

    fun setSessionToken(token: String){
        val editor = sharedPreferences.edit()
        editor.putString(KEY_SESSION_TOK, token)
        editor.apply()
    }

    fun getSessionToken(): String {
        return sharedPreferences.getString(KEY_SESSION_TOK, "") ?: ""
    }

    companion object{
        const val KEY_SHARED_PRP_NAME = "UserData"
        const val KEY_SESSION_TOK = "session_token"
    }
}