package com.amandapeixoto.loginapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var welcomeTextView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        welcomeTextView = findViewById(R.id.welcomeTextView)

        loginButton.setOnClickListener(View.OnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username == "amanda" && password == "1234") {
                val welcomeMessage = "Bem-vindo, $username!"
                welcomeTextView.text = welcomeMessage
            } else {
                val errorMessage = "Nome de usuário ou senha incorretos."
                welcomeTextView.text = errorMessage
            }
        })

    }
}