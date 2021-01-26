package com.ruangaldo.loginwithMVVM.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.blank.ch6_ex.data.db.UserDao
import com.blank.ch6_ex.data.db.UserEntity

@Database (entities = [UserEntity::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun dataUser(): UserDao
}