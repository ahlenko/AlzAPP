package com.mycompany.alztestapp.screens.mainmenu.fragments.membership

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mycompany.alztestapp.R
import com.mycompany.alztestapp.databinding.FragmentMembershipBinding

class MembershipFragment : Fragment() {
    private lateinit var binding: FragmentMembershipBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMembershipBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.answerItButton.setOnClickListener{
            findNavController().navigate(R.id.action_membershipFragment_to_questionFragment)
        }

        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_membershipFragment_to_mainMenuFragment)
        }

        binding.freeMembButton.setOnClickListener{

        }

        binding.payMembButton.setOnClickListener{

        }
    }
}