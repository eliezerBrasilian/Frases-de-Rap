package com.historias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import principal.fraseparastatus.frasesderapparastatus.R
import android.content.Intent
import android.widget.TextView
class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val haveAccountText = findViewById<TextView>(R.id.have_account_text)
        haveAccountText.setOnClickListener { goToLoginActivity() }
    }
    private fun goToLoginActivity(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}