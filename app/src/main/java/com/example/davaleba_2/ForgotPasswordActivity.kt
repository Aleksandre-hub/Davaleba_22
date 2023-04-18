package com.example.davaleba_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var enterUrEmail : EditText
    private lateinit var SendRecover : Button
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        init()



        SendRecover.setOnClickListener {
            if (enterUrEmail.text.length < 5) {
                Toast.makeText(this, "WRITE THE EMAIL BRO", Toast.LENGTH_SHORT).show()
            }else {
                auth.sendPasswordResetEmail(enterUrEmail.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Recovery is sent to you email", Toast.LENGTH_SHORT).show()
                        goToLogin()
                    }else {
                        Toast.makeText(this, "something is wrong lol (albat sheni maili ar arsebobs :D)", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }

    private fun goToLogin() {
        startActivity(Intent(this,LoginActivity::class.java))
        finish()
    }

    private fun init() {
        enterUrEmail = findViewById(R.id.EnterurEmaail)
        SendRecover = findViewById(R.id.SendRecover)
    }
}