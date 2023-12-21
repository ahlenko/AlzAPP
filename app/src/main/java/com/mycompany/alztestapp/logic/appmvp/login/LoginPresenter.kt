package com.mycompany.alztestapp.logic.appmvp.login

class LoginPresenter (private val mView: LoginContract.View): LoginContract.Presenter {

    private var mRepository: LoginContract.Repository = LoginRepository()

    private var message:String = ""

    override fun performRegister(username: String, password: String) {
        Thread { message = mRepository.performRegister(username, password)
        if (message == "OK") mView.onSuccessLogin("")
        else mView.onLoginError(message)}.start()
    }

    override fun performLogin(username: String, password: String) {
        Thread { message = mRepository.performLogin(username, password)
        if (message != "ERROR" && message != "FAILED") mView.onSuccessLogin(message)
        else mView.onLoginError(message)}.start()
    }
}