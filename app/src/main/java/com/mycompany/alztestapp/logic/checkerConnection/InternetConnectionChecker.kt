package com.mycompany.alztestapp.logic.checkerConnection

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class InternetConnectionChecker {
    companion object{
        fun isInternetAvailable(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            return networkInfo?.isConnected == true
        }
    }
}