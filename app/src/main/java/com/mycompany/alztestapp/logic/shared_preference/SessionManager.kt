package com.mycompany.alztestapp.logic.shared_preference

import android.content.Context
import android.content.SharedPreferences

class SessionManager (context: Context) {
    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(KEY_SHARED_PRP_NAME, Context.MODE_PRIVATE)

//    fun questionINC() {
//        val currentCount = getQuestionAnsCount()
//        setQuestionAnsCount(currentCount + 1)
//    }
//
//    fun getQuestionAnsCount(): Int {
//        return sharedPreferences.getInt(KEY_QUESTION_ANS, 0)
//    }
//
//    fun setQuestionAnsCount(count: Int) {
//        val editor = sharedPreferences.edit()
//        editor.putInt(KEY_QUESTION_ANS, count)
//        editor.apply()
//    }

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
//      const val KEY_QUESTION_ANS = "question_answered"
    }
}