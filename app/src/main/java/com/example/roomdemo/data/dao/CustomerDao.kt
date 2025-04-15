package com.example.roomdemo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdemo.data.entities.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Query("SELECT * FROM customer")
    fun fetchAlCustomer(): Flow<List<Customer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer)

    @Query("DELETE FROM customer WHERE id = :id")
    suspend fun deleteCustomerById(id: Int)

    @Query("DELETE FROM customer")
    suspend fun deleteAllCustomer()

}