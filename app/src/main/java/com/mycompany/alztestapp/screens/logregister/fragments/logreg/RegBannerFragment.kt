package com.mycompany.alztestapp.screens.logregister.fragments.logreg

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.mycompany.alztestapp.R
import com.mycompany.alztestapp.databinding.FragmentRegBannerBinding
import com.mycompany.alztestapp.logic.checkerConnection.InternetConnectionChecker

class RegBannerFragment : Fragment() {
    private lateinit var binding: FragmentRegBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegBannerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moreInfoButton.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(REDIRECT_MORE_INFO_URL))
            startActivity(intent)
        }

        binding.rebButton.setOnClickListener{
            if (InternetConnectionChecker.isInternetAvailable(requireContext()))
                findNavController().navigate(R.id.action_regBannerFragment_to_registerFragment)
            else Toast.makeText(requireContext(), R.string.internet_unavalible, Toast.LENGTH_LONG).show()
        }
    }

    companion object{
        const val REDIRECT_MORE_INFO_URL = "https://www.facebook.com/ALzTest/posts/pfbid025asYyFNXwLZvfJYw7JpiTsejrrgPcREFvtPPNUQTzwsD"
    }
}