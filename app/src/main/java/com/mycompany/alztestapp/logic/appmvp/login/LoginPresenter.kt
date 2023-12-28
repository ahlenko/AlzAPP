package com.mycompany.alztestapp.logic.appmvp.login

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.core.Single

class LoginPresenter (private val mView: LoginContract.View): LoginContract.Presenter {

    private var mRepository: LoginContract.Repository = LoginRepository()

    override fun performRegister(username: String, password: String) {
        Single.fromCallable { mRepository.performRegister(username, password) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { responseResult ->
                if (responseResult.isSuccessful) {
                    responseResult.body()?.message ?: "OK"
                } else "ERROR"
            }.doOnSuccess { message ->
                if (message == "OK") mView.onSuccessLogin("")
                else mView.onLoginError(message)
            }.doOnError { error ->
                mView.onLoginError(error.localizedMessage ?: "Unknown error")
        }.subscribe()
    }

    override fun performLogin(username: String, password: String) {
        Single.fromCallable { mRepository.performLogin(username, password) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { responseResult ->
                if (responseResult.isSuccessful) {
                    responseResult.body()?.result?.sessionToken ?: "FAILED"
                } else "ERROR"
            }.doOnSuccess { message ->
                if (message != "ERROR" && message != "FAILED") mView.onSuccessLogin(message)
                else mView.onLoginError(message)
            }.doOnError { error ->
                mView.onLoginError(error.localizedMessage ?: "Unknown error")
        }.subscribe()
    }
}