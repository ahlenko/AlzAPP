package com.mycompany.alztestapp.logic.appmvp.login

import android.annotation.SuppressLint
import com.mycompany.alztestapp.logic.appmvp.login.response.LoginModel
import com.mycompany.alztestapp.logic.appmvp.login.response.RegistrationModel
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date

class LoginRepository : LoginContract.Repository {
    override fun performRegister(username: String, password:String): Response<RegistrationModel> {
        val call = LoginRetrofitService.getInstance()
            .registerUser(username, password, getCurrentDate(), "_", "_")
        return call.execute()
    }

    override fun performLogin(username: String, password:String): Response<LoginModel> {
        val call = LoginRetrofitService.getInstance()
            .loginUser(username, password)
        return call.execute()
    }

    @SuppressLint("SimpleDateFormat")
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val currentDate = Date(System.currentTimeMillis())
        return dateFormat.format(currentDate)
    }
}