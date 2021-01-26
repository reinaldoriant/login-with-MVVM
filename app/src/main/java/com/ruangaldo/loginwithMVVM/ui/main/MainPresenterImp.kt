package com.ruangaldo.loginwithMVVM.ui.main

import com.ruangaldo.loginwithMVVM.data.local.SharedPref
import com.blank.ch6_ex.data.model.Users
import com.ruangaldo.loginwithMVVM.ui.main.MainActivityPresenter
import com.ruangaldo.loginwithMVVM.ui.main.MainView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainPresenterImp(private val view: MainView) : MainActivityPresenter {
    override fun getUser(id: Int) {
        GlobalScope.launch(Dispatchers.IO)
        {
          /*  val userEntity = appDb
                ?.dataUser()?.fetchUserbyId(id)
            //launch ini memindahkan ke UI agar bisa ditampillkan, karena launch yang pertama masih proses background (tidak punya UI)
            launch(Dispatchers.Main) {
                if (userEntity != null) {
                 *//*   val usersList = mutableListOf<UserEntity>()
                        .map {
                            Users(it.id, userEntity.nama, userEntity.umur, userEntity.gender)
                        }
                    val a = usersList*//*
                    val user = Users(userEntity.id, userEntity.nama, userEntity.umur, userEntity.gender)
                    view.onSuccess(user)*/
                }
            }

    override fun logout() {
        TODO("Not yet implemented")
    }
}


    /*override fun logout(){
        SharedPref.isLogin = false
    }*/


