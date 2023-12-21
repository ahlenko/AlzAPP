package com.mycompany.alztestapp.screens.mainmenu.fragments.menu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mycompany.alztestapp.R
import com.mycompany.alztestapp.databinding.FragmentMainMenuBinding
import com.mycompany.alztestapp.logic.navigation.NavigationInterface

class MainMenuFragment : Fragment() {
    private lateinit var binding: FragmentMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myProgressButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenuFragment_to_testResultFragment)
        }

        binding.aboutUsButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(REDIRECT_ABOUT_US_URL))
            startActivity(intent)
        }

        binding.moreQuestionButton.setOnClickListener{
            findNavController().navigate(R.id.action_mainMenuFragment_to_membershipFragment)
        }

        binding.moreInfoButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(REDIRECT_MORE_INFO_URL))
            startActivity(intent)
        }

        binding.logOutButton.setOnClickListener{
            if (requireActivity() is NavigationInterface)
                (requireActivity() as NavigationInterface).navigateToNextScreen()
        }

        binding.deactivateAccButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(DEACTIVATE_ACCOUNT_URL))
            startActivity(intent)
        }
    }

    companion object{
        const val REDIRECT_ABOUT_US_URL = "https://www.facebook.com/ALzTest"
        const val REDIRECT_MORE_INFO_URL = "https://www.facebook.com/ALzTest/posts/pfbid025asYyFNXwLZvfJYw7JpiTsejrrgPcREFvtPPNUQTzwsD"
        const val DEACTIVATE_ACCOUNT_URL = "https://clinicalselfie.com/"
    }
}