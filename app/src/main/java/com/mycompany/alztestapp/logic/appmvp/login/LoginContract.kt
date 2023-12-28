package com.mycompany.alztestapp.logic.appmvp.login

import com.mycompany.alztestapp.logic.appmvp.login.response.LoginModel
import com.mycompany.alztestapp.logic.appmvp.login.response.RegistrationModel
import retrofit2.Response

interface LoginContract {
    interface View {
        fun onSuccessLogin(sessionKey: String)
        fun onLoginError(message: String)
    }

    interface Presenter {
        fun performRegister(username: String, password:String)
        fun performLogin(username: String, password:String)
    }

    interface Repository {
        fun performRegister(username: String, password:String): Response<RegistrationModel>
        fun performLogin(username: String, password:String): Response<LoginModel>
    }
}