package com.ruangaldo.loginwithMVVM.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.ruangaldo.loginwithMVVM.data.db.AppDb
import com.ruangaldo.loginwithMVVM.ui.main.MainActivity
import com.ruangaldo.loginwithMVVM.ui.register.RegisterActivity
import com.ruangaldo.loginwithMVVM.R
import com.ruangaldo.loginwithMVVM.data.local.SharedPref
import com.ruangaldo.loginwithMVVM.utils.text

class LoginActivity : AppCompatActivity(), LoginNavigator {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val db= Room
            .databaseBuilder(this, AppDb::class.java,"myDb")
            .allowMainThreadQueries()
            .build()
        val pref=SharedPref(this)
        val factory=LoginViewModel.Factory(db, pref)
        loginViewModel=ViewModelProvider(this,factory)[LoginViewModel::class.java]
        loginViewModel.navigator=this
        if(loginViewModel.checkIsLogin()){
            onSuccess()
        }
        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnLogin.setOnClickListener {
            loginViewModel.login(username.text(),password.text())
        }

        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun onSuccess() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}