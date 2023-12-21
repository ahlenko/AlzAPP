package com.mycompany.alztestapp.logic.appmvp.login

interface LoginContract {
    interface View {
        fun onLoginError(message: String)
        fun onSuccessLogin(sessionKey: String)
    }

    interface Presenter {
        fun performRegister(username: String, password:String)
        fun performLogin(username: String, password:String)
    }

    interface Repository {
        fun performLogin(username: String, password:String): String
        fun performRegister(username: String, password:String): String
    }
}