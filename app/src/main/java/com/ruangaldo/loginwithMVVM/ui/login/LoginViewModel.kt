package com.ruangaldo.loginwithMVVM.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ruangaldo.loginwithMVVM.data.db.AppDb
import com.ruangaldo.loginwithMVVM.data.local.SharedPref
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class LoginViewModel(private val db: AppDb, private val pref: SharedPref) : ViewModel() {
    var navigator: LoginNavigator? = null
    fun login(username: String, passwrd: String) {
        GlobalScope.launch(Dispatchers.IO)
        {
            val userEntity = db
                .dataUser().fetchUserbyName(username)
            launch(Dispatchers.Main) {
                if (username == userEntity.nama) {
                    pref.isLogin = true
                    pref.id = userEntity.id
                    navigator?.onSuccess()
                } else {
                    navigator?.onError("Username atau password kamuuhh salah!!")
                }
            }
        }
    }

    fun checkIsLogin(): Boolean = pref.isLogin == true
    class Factory(private val db: AppDb, private val pref: SharedPref):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return LoginViewModel(db, pref) as T
        }


    }
    /*override fun login(username: String, passwrd: String) {
        val appDb = App.appDb

        GlobalScope.launch(Dispatchers.IO)
        {
            val userEntity = appDb
                ?.dataUser()?.fetchUserbyName(username)
            //launch ini memindahkan ke UI agar bisa ditampillkan, karena launch yang pertama masih proses background (tidak punya UI)
            launch(Dispatchers.Main){
                if (username == userEntity?.nama) {
                    SharedPref.isLogin = true
                    SharedPref.id = userEntity.id
                    navigator.onSuccess(userEntity.id)
                } else {
                    navigator.onError("Username atau password kamuuhh salah!!")
                }
            }
        }
    }
    override fun checkIsLogin(): Boolean = SharedPref.isLogin == true
    override fun getId(): Int? = SharedPref.id*/
}