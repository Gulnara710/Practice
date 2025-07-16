package com.summer.practice

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPassword = findViewById<TextView>(R.id.tvPassword)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        tvEmail.text = getString(R.string.email_display, email)
        tvPassword.text = getString(R.string.password_display, password)
    }
}