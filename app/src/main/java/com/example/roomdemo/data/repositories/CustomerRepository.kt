package com.example.roomdemo.data.repositories

import android.app.Application
import com.example.roomdemo.data.AppDatabase
import com.example.roomdemo.data.dao.CustomerDao
import com.example.roomdemo.data.entities.Customer
import kotlinx.coroutines.flow.Flow

class CustomerRepository(application: Application) {

    private val customerDao: CustomerDao

    init {
        val database = AppDatabase.getDatabase(application)
        customerDao = database.customerDao()
    }

    fun readAllCustomer(): Flow<List<Customer>> {
        return customerDao.fetchAlCustomer()
    }

    suspend fun insertCustomer(customer: Customer) {
        customerDao.insertCustomer(customer)
    }

    suspend fun deleteCustomerById(id: Int) {
        customerDao.deleteCustomerById(id)
    }

    suspend fun deleteAllCustomer() {
        customerDao.deleteAllCustomer()
    }
}//CustomerRepository