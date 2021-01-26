package com.ruangaldo.loginwithMVVM.ui.register

interface RegisterPresenter {
    fun register(username: String, umur: String, password: String, gender: String)
}