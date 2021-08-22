package ua.javabegin.examples.mychat5.ui.fragment

import android.os.Bundle
import android.view.View
import ua.javabegin.examples.mychat5.R
import ua.javabegin.examples.mychat5.domain.type.None
import ua.javabegin.examples.mychat5.presentation.viewmodel.AccountViewModel
import ua.javabegin.examples.mychat5.ui.App
import ua.javabegin.examples.mychat5.ui.core.onFailure
import ua.javabegin.examples.mychat5.ui.core.onSuccess
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment: BaseFragment() {
    override val layoutId = R.layout.fragment_register
    override val titleToolbar = R.string.register

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)

        accountViewModel = viewModel {
            onSuccess(registerData, ::handleRegister)
            onFailure(failureData, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNewMembership.setOnClickListener {
            register()
        }
    }

    private fun validateFields(): Boolean {

        val allFields = arrayOf(etEmail, etUsername, etPassword, etConfirmPassword)
        var allValid = true
        for(field in allFields) {
            allValid = field.testValidity() && allValid
        }

        return allValid && validatePasswords()
    }

    private fun validatePasswords(): Boolean {
        val valid = etPassword.text.toString() == etConfirmPassword.text.toString()
        if (!valid) {
           showMessage(getString(R.string.error_password_mismatch))
        }
        return  valid
    }

    private fun register() {
        hideSoftKeyboard()

        val allValid = validateFields()
        if(allValid) {
            showProgress()

            accountViewModel.register(etEmail.text.toString(), etPassword.text.toString(), etUsername.text.toString())
        }
    }

    private fun handleRegister(none: None? = None()) {
        hideProgress()
        showMessage("Account Created!")
    }

}