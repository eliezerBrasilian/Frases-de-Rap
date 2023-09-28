package com.historias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import principal.fraseparastatus.frasesderapparastatus.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val dontHaveAccountText = findViewById<TextView>(R.id.dont_have_account_text)
        dontHaveAccountText.setOnClickListener { goToSignUpActivity() }

    }
    private fun goToSignUpActivity(){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}