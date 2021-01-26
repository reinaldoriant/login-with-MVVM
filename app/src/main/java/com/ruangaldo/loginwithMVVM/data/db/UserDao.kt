package com.blank.ch6_ex.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: UserEntity)

    @Query("SELECT * FROM Users WHERE nama = :nama LIMIT 1")
    fun fetchUserbyName(nama: String): UserEntity
    @Query("SELECT * FROM Users WHERE id = :id LIMIT 1")
    fun fetchUserbyId(id: Int): UserEntity
}