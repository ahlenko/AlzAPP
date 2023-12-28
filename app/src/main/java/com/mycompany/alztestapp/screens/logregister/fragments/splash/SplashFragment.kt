package com.mycompany.alztestapp.screens.logregister.fragments.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mycompany.alztestapp.R
import com.mycompany.alztestapp.databinding.FragmentSplashBinding
import com.mycompany.alztestapp.logic.navigation.NavigationInterface
import com.mycompany.alztestapp.logic.shared_preference.SessionManager

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userData = SessionManager(requireContext())

        Handler(Looper.getMainLooper()).postDelayed({
            if (userData.getSessionToken() != "") {
                if (requireActivity() is NavigationInterface)
                    (requireActivity() as NavigationInterface).navigateToNextScreen()
            } else findNavController().navigate(R.id.action_splashFragment_to_regBannerFragment)
        }, TIMEOUT_SCREEN)
    }

    companion object {
        const val TIMEOUT_SCREEN:Long = 3000
    }
}