package com.mycompany.alztestapp.screens.mainmenu.fragments.resulttest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mycompany.alztestapp.R
import com.mycompany.alztestapp.databinding.FragmentTestResultBinding

class TestResultFragment : Fragment() {
    private lateinit var binding: FragmentTestResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestResultBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_testResultFragment_to_mainMenuFragment)
        }

        binding.seeResultButton.setOnClickListener{
            findNavController().navigate(R.id.action_testResultFragment_to_membershipFragment)
        }

        binding.resultMeansButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(REDIRECT_RESULT_MEANS_URL))
            startActivity(intent)
        }
    }

    companion object{
        const val REDIRECT_RESULT_MEANS_URL = "https://clinicalselfie.com/"
    }

}