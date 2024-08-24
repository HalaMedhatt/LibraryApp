package com.hala.libraryapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.hala.libraryapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var  progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth=FirebaseAuth.getInstance()
        progressDialog= ProgressDialog(this)
        progressDialog.setTitle("Pleas Wait")
        progressDialog.setCanceledOnTouchOutside(false)
        binding.loginButton.setOnClickListener{
            validateData()
            startActivity(Intent(this,HomeActivity2::class.java))
        }
        }
    private var email=""
    private var password=""

    private fun validateData() {
        email=binding.emailEditText.text.toString().trim()
        password=binding.passwordEditText.text.toString().trim()
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            Toast.makeText(this,"Invalid Email...",Toast.LENGTH_SHORT).show()
        if(password.isEmpty())
            Toast.makeText(this,"Enter the Password...",Toast.LENGTH_SHORT).show()
    }
}