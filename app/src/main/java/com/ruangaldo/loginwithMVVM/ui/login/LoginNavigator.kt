package com.ruangaldo.loginwithMVVM.ui.login

interface LoginNavigator {
    fun onSuccess(id:Int)
    fun onError(msg: String)
}