package com.mycompany.alztestapp.screens.mainmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mycompany.alztestapp.databinding.ActivityMainMenuBinding
import com.mycompany.alztestapp.screens.logregister.RegLoginActivity
import com.mycompany.alztestapp.logic.navigation.NavigationInterface
import com.mycompany.alztestapp.logic.shared_preference.SessionManager

class MainMenuActivity : AppCompatActivity(), NavigationInterface {
    lateinit var binding: ActivityMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun navigateToNextScreen() {
        val userData = SessionManager(this)
        userData.setSessionToken("")
        startActivity(Intent(this, RegLoginActivity::class.java))
        finish()
    }
}