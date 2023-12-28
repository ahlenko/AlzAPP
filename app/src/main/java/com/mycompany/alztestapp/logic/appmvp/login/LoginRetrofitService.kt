package com.mycompany.alztestapp.logic.appmvp.login

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginRetrofitService private constructor() {

    val apiService: LoginApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(APP_SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(LoginApiService::class.java)
    }

    companion object {
        const val APP_SERVER_BASE_URL = "http://208.74.203.229/alzheimer/"

        private var instance: LoginRetrofitService? = null

        fun getInstance(): LoginApiService {
            if (instance == null) {
                synchronized(LoginRetrofitService::class.java) {
                    if (instance == null) {
                        instance = LoginRetrofitService()
                    }
                }
            }
            return instance?.apiService!!
        }
    }
}