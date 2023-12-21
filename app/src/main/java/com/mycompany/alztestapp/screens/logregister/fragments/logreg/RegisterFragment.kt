package com.mycompany.alztestapp.screens.logregister.fragments.logreg

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mycompany.alztestapp.R
import com.mycompany.alztestapp.databinding.FragmentRegisterBinding
import com.mycompany.alztestapp.logic.appmvp.login.LoginContract
import com.mycompany.alztestapp.logic.appmvp.login.LoginPresenter
import com.mycompany.alztestapp.logic.dialogs.DialogHelper

class RegisterFragment : Fragment(), LoginContract.View {

    private lateinit var mPresenter: LoginContract.Presenter

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        mPresenter = LoginPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener{
            val textEmail = binding.usernameEnter.text.toString().trim()
            val textPass = binding.passwordEnter.text.toString().trim()
            val isTermsChecked = binding.agreeSwitch.isChecked

            val checkFieldsResult = fieldsRightCheck(textEmail, textPass, isTermsChecked)
            if(checkFieldsResult == "+")
                mPresenter.performRegister(textEmail, textPass)
            else onLoginError(checkFieldsResult)
        }

        binding.signinButton.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_logInFragment)
        }
    }

    private fun fieldsRightCheck(email: String, pass: String, check: Boolean): String {
        return if (!check)
            getString(R.string.no_checked_terms_error)
        else if (email.isEmpty() || pass.isEmpty())
            getString(R.string.fields_empty_error)
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            getString(R.string.email_format_error)
        else if (pass.length < 4)
            getString(R.string.pass_size_error)
        else if (!pass.matches("^[a-zA-Z0-9]+$".toRegex()))
            getString(R.string.pass_contains_ch_error)
        else "+"
    }

    override fun onLoginError(message: String) {
        requireActivity().runOnUiThread{
            DialogHelper.showInformationDialog(requireContext(), message, getString(R.string.confirm))
        }
    }

    override fun onSuccessLogin(sessionKey: String) {
        findNavController().navigate(R.id.action_registerFragment_to_logInFragment)
    }
}