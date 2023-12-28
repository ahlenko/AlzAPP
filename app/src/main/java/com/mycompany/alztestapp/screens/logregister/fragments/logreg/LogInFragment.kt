package com.mycompany.alztestapp.screens.logregister.fragments.logreg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mycompany.alztestapp.R
import com.mycompany.alztestapp.databinding.FragmentLogInBinding
import com.mycompany.alztestapp.logic.appmvp.login.LoginContract
import com.mycompany.alztestapp.logic.appmvp.login.LoginPresenter
import com.mycompany.alztestapp.logic.dialogs.DialogHelper
import com.mycompany.alztestapp.logic.navigation.NavigationInterface
import com.mycompany.alztestapp.logic.shared_preference.SessionManager

class LogInFragment : Fragment(), LoginContract.View {

    private lateinit var mPresenter: LoginContract.Presenter

    private lateinit var binding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogInBinding.inflate(layoutInflater)
        mPresenter = LoginPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signinButton.setOnClickListener {
            val textEmail = binding.usernameEnter.text.toString().trim()
            val textPass = binding.passwordEnter.text.toString().trim()
            val checkFieldsResult = fieldsRightCheck(textEmail, textPass)
            if (checkFieldsResult == "+")
                mPresenter.performLogin(textEmail, textPass)
            else onLoginError(checkFieldsResult)
        }

        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_registerFragment)
        }
    }

    private fun fieldsRightCheck(email: String, pass: String): String {
        return if (email.isEmpty() || pass.isEmpty())
            getString(R.string.fields_empty_error)
        else "+"
    }

    override fun onLoginError(message: String) {
        when (message) {
            "ERROR" -> DialogHelper.showInformationDialog( requireContext(),
                getString(R.string.send_request_error), getString(R.string.confirm))
            "FAILED" -> DialogHelper.showInformationDialog( requireContext(),
                getString(R.string.no_right_login_data), getString(R.string.confirm))
        }
    }

    override fun onSuccessLogin(sessionKey: String) {
        val userData = SessionManager(requireContext())
        if (requireActivity() is NavigationInterface)
            (requireActivity() as NavigationInterface).navigateToNextScreen()
        userData.setSessionToken(sessionKey)
    }
}