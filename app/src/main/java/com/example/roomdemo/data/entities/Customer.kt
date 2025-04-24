package com.example.roomdemo.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "customer")
data class Customer(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "age")
    val age: Int?,
    @ColumnInfo(name = "email_id")
    val emailId: String?,
)
