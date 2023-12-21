package com.mycompany.alztestapp.logic.appmvp.login

import com.mycompany.alztestapp.logic.appmvp.login.response.LoginModel
import com.mycompany.alztestapp.logic.appmvp.login.response.RegistrationModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginApiService {
    @FormUrlEncoded
    @POST(LoginRepository.SERVER_REG_URL)
    fun registerUser(
        @Field(KEY_EMAIL) email: String,
        @Field(KEY_PASS) password: String,
        @Field(KEY_DATE) dateOfBirth: String,
        @Field(KEY_GENDER) gender: String,
        @Field(KEY_PHONE) phone: String
    ): Call<RegistrationModel>

    @FormUrlEncoded
    @POST(LoginRepository.SERVER_LOG_URL)
    fun loginUser(
        @Field(KEY_EMAIL) email: String,
        @Field(KEY_PASS) password: String
    ): Call<LoginModel>

    companion object{
        const val KEY_EMAIL = "email"
        const val KEY_PASS = "password"
        const val KEY_DATE = "date_of_birth"
        const val KEY_GENDER = "gender"
        const val KEY_PHONE = "phone"
    }
}