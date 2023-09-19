package com.amandapeixoto.loginapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arquivo = getSharedPreferences("username_password", Context.MODE_PRIVATE)

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener(this)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
    }

    override fun onClick(view: View?) {
        val arquivo = getSharedPreferences("username_password", Context.MODE_PRIVATE)
        val username = arquivo.getString("login", "")
        val password = arquivo.getString("senha", "")

        if (username == "" && password == "") {
            val editor = arquivo.edit()
            editor.putString("login", usernameEditText.text.toString())
            editor.putString("senha", passwordEditText.text.toString())
            editor.commit()
            Toast.makeText(
                this,
                "Bem vindo ao primeiro acesso!", //
                Toast.LENGTH_LONG
            ).show()
        } else if ( usernameEditText.text.toString().equals(username) //
            and passwordEditText.text.toString().equals(password) ) {
            Toast.makeText(
                this,
                "Usuário e senha corretos!", //
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                this,
                "Usuário e/ou senha inválidos!", //
                Toast.LENGTH_LONG
            ).show()
        }
    }

}