package com.ruangaldo.loginwithMVVM.data.local

import android.content.Context

class SharedPref(private val context: Context) {
    private val KEY_NAMA = "KEY_NAMA"
    private val KEY_ID = "KEY_ID"
    private val KEY_UMUR = "KEY_UMUR"
    private val KEY_GENDER = "KEY_GENDER"
    private val KEY_ISLOGIN = "KEY_ISLOGIN"

    private val pref = context.getSharedPreferences("ch6", Context.MODE_PRIVATE)

    /*   fun mappingToPref(users: Users) {
           pref?.edit()
               ?.putInt(KEY_ID, users.id)
               ?.apply()

           pref?.edit()
               ?.putString(KEY_NAMA, users.nama)
               ?.apply()

           pref?.edit()
               ?.putString(KEY_UMUR, users.umur)
               ?.apply()

           pref?.edit()
               ?.putString(KEY_GENDER, users.gender)
               ?.apply()
       }

       fun getUser(): Users {
           val id = pref?.getInt(KEY_ID, 0) ?: 0
           val nama = pref?.getString(KEY_NAMA, "").toString()
           val umur = pref?.getString(KEY_UMUR, "").toString()
           val gender = pref?.getString(KEY_GENDER, "").toString()
           return Users(id, nama, umur, gender)
       }*/

    var isLogin: Boolean?
        get() = pref?.getBoolean(KEY_ISLOGIN, false)
        set(value) {
            value?.let {
                pref?.edit()
                    ?.putBoolean(KEY_ISLOGIN, it)
                    ?.apply()
            }
        }
    var id: Int?
        get() = pref?.getInt(KEY_ID, 0)
        set(value) {
            value?.let {
                pref?.edit()
                    ?.putInt(KEY_ID, it)
                    ?.apply()
            }
        }
}