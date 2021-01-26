package com.ruangaldo.loginwithMVVM.ui.register

import com.blank.ch6_ex.data.db.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterPresenterImp(private val view: RegisterView) : RegisterPresenter {

    override fun register(username: String, umur: String, password: String, gender: String) {
  /*      val newUser = UserEntity(username, umur, gender)
        val appDb = App.appDb

        GlobalScope.launch(Dispatchers.IO) {
            val userEntity = appDb
                ?.dataUser()?.fetchUserbyName(username)
            if (username == userEntity?.nama) {
                launch(Dispatchers.Main) {
                    view.onError("Username kamu sama!")
                }
            } else
            {
                appDb?.dataUser()
                    ?.insert(newUser)
                launch (Dispatchers.Main){
                    view.onSuccess()
                }
            }
        }*/
    }
}