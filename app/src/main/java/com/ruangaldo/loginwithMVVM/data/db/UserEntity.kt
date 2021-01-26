package com.blank.ch6_ex.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class UserEntity(
    @ColumnInfo(name = "nama")
    val nama: String,
    @ColumnInfo(name = "umur")
    val umur: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)



