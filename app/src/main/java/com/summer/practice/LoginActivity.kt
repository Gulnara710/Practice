package com.summer.practice

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                validateInputs(etEmail.text.toString(), etPassword.text.toString(), btnSubmit)
            }
        }

        etEmail.addTextChangedListener(textWatcher)
        etPassword.addTextChangedListener(textWatcher)

        btnSubmit.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            startActivity(intent)
        }
    }

    private fun validateInputs(email: String, password: String, button: Button) {

        val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(email).matches()

        val isPasswordValid = password.length >= 8 &&
                password.any { it.isDigit() } &&
                password.any { it.isUpperCase() } &&
                password.any { it.isLowerCase() }

        button.isEnabled = isEmailValid && isPasswordValid
    }
}