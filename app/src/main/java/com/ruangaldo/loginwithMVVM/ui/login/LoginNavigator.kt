package com.ruangaldo.loginwithMVVM.ui.login

interface LoginNavigator {
    fun onSuccess()
    fun onError(msg: String)
}