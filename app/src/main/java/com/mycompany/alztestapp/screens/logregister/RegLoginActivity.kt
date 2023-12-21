package com.mycompany.alztestapp.screens.logregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mycompany.alztestapp.databinding.ActivityRegistrationBinding
import com.mycompany.alztestapp.logic.navigation.NavigationInterface
import com.mycompany.alztestapp.screens.mainmenu.MainMenuActivity

class RegLoginActivity : AppCompatActivity(), NavigationInterface {
    lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun navigateToNextScreen() {
        startActivity(Intent(this, MainMenuActivity::class.java))
        finish()
    }
}