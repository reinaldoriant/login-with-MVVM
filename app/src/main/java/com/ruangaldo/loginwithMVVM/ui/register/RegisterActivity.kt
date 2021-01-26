package com.ruangaldo.loginwithMVVM.ui.register

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.ruangaldo.loginwithMVVM.ui.login.LoginActivity
import com.ruangaldo.loginwithMVVM.utils.text
import com.ruangaldo.loginwithMVVM.R

class RegisterActivity : AppCompatActivity(), RegisterView {
    private var presenter: RegisterPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter = RegisterPresenterImp(this)

        val username = findViewById<EditText>(R.id.etUsername)
        val passwrd = findViewById<EditText>(R.id.etPassword)
        val umur = findViewById<EditText>(R.id.etUmur)
        val gender = findViewById<EditText>(R.id.etGender)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            presenter?.register(username.text(), umur.text(), passwrd.text(), gender.text())
        }
    }

    override fun onError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess() {
        finish()
    }

    override fun onBackPressed() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}