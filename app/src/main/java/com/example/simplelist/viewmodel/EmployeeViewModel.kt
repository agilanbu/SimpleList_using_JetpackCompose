package com.example.simplelist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplelist.model.Employee
import com.example.simplelist.repository.EmployeeRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class EmployeeViewModel(private val repository: EmployeeRepository) : ViewModel() {
    private val _empList = MutableLiveData<List<Employee>>()
    val emplist: LiveData<List<Employee>> = _empList
    private val tag = "APILogger"

    init {
        loadEmployees()
    }

    private fun loadEmployees() {
        viewModelScope.launch {
            try {
                coroutineScope {
                    val employeesDeferred = async { repository.getEmployee() }
                    val employeesResponse = employeesDeferred.await()
                    if (employeesResponse.isNotEmpty()) {
                        _empList.postValue(employeesResponse)
                    } else {
                        Log.e(tag, "EMPLOYEES---FALSE::")
                    }
                }
            } catch (e: Exception) {
                Log.e(tag, "EXCEPTION::" + e.message)
            }
        }
    }

}