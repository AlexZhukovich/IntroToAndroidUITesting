package com.alexzh.testapp.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexzh.testapp.R
import com.alexzh.testapp.data.DummyData
import com.alexzh.testapp.ext.isNotValidEmail
import com.alexzh.testapp.ui.home.HomeActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        logoImageView.tag = R.drawable.ic_lock_24dp

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isBlank() && password.isBlank()) {
                displayMessage(getString(R.string.email_and_password_are_blank))
                return@setOnClickListener
            }

            if (email.isBlank() && password.isNotBlank()) {
                displayMessage(getString(R.string.email_is_blank))
                return@setOnClickListener
            }

            if (password.isBlank() && email.isNotEmpty()) {
                displayMessage(getString(R.string.password_is_blank))
                return@setOnClickListener
            }

            if (email.isNotValidEmail()) {
                displayMessage(getString(R.string.text_is_not_email))
                return@setOnClickListener
            }

            if (!(email == DummyData.LOGIN && password == DummyData.PASSWORD)) {
                displayMessage(getString(R.string.check_email_and_password))
                return@setOnClickListener
            }

            if (!agreeCheckBox.isChecked) {
                displayMessage(getString(R.string.i_agree_should_be_checked))
                return@setOnClickListener
            }

            HomeActivity.start(this)
        }
    }

    private fun displayMessage(text: String) {
        Snackbar.make(root, text, Snackbar.LENGTH_LONG).show()
    }
}
