package com.example.roomdemo.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdemo.data.entities.Customer
import com.example.roomdemo.data.repositories.CustomerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CustomerViewModel(appObj: Application) : AndroidViewModel(appObj) {

    private val repository = CustomerRepository(appObj)

    private var _customerList = fetchAllCustomer()
    val customerList: Flow<List<Customer>> get() = _customerList

    fun fetchAllCustomer(): Flow<List<Customer>> = repository.readAllCustomer()

    fun insertCustomer(customer: Customer) {
        viewModelScope.launch { repository.insertCustomer(customer) }
    }

    fun deleteCustomerById(id: Int) {
        viewModelScope.launch { repository.deleteCustomerById(id) }
    }

    fun deleteAllCustomer() {
        viewModelScope.launch { repository.deleteAllCustomer() }
    }

}//CustomerViewModel