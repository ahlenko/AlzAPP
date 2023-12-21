package com.mycompany.alztestapp.logic.appmvp.login

import android.annotation.SuppressLint
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date

class LoginRepository : LoginContract.Repository {

    override fun performRegister(username: String, password:String): String {
        val retrofit = Retrofit.Builder()
            .baseUrl(APP_SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(LoginApiService::class.java)

        val call = apiService.registerUser(username, password, getCurrentDate(), "_", "_")
        val response = call.execute()

        return if (response.isSuccessful) {
            val responseModel = response.body()
            responseModel?.message ?: "OK"
        } else "ERROR"
    }

    override fun performLogin(username: String, password:String): String {
        val retrofit = Retrofit.Builder()
            .baseUrl(APP_SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(LoginApiService::class.java)

        val call = apiService.loginUser(username, password)

        val response = call.execute()

        return if (response.isSuccessful) {
            val responseModel = response.body()
            responseModel?.resultSessionKey?.sessionToken ?: "FAILED"
        } else "ERROR"
    }

    @SuppressLint("SimpleDateFormat")
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val currentDate = Date(System.currentTimeMillis())
        return dateFormat.format(currentDate)
    }

    companion object {
        const val APP_SERVER_BASE_URL = "http://208.74.203.229/alzheimer/"
        const val SERVER_REG_URL = "user/register/"
        const val SERVER_LOG_URL = "user/login/"
    }
}