package com.ruangaldo.loginwithMVVM.ui.register

import android.content.Context
import androidx.room.Room
import com.ruangaldo.loginwithMVVM.data.db.AppDb
import com.blank.ch6_ex.data.db.UserEntity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterPresenterImp(private val view: RegisterView) : RegisterPresenter {

    override fun register(username: String, umur: String, password: String, gender: String) {

        val userEntity = UserEntity(username, umur, gender)
        val db = Room
            .databaseBuilder((view as Context), AppDb::class.java, "myDb")
            .allowMainThreadQueries()
            .build()
        GlobalScope.launch {

            db.dataUser()
                .insert(userEntity)
        }

        view.onSuccess()


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
