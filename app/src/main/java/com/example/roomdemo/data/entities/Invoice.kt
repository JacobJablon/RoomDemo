package com.example.roomdemo.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "invoice")
data class Invoice(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "customer_id")
    val customerId: Int?,
    @ColumnInfo(name = "payee")
    val payee: String?,
    @ColumnInfo(name = "amount")
    val amount: Double?,
    @ColumnInfo(name = "due_date")
    val dueDate: Date?,
)