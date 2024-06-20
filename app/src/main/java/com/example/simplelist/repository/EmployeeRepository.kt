package com.example.simplelist.repository

import com.example.simplelist.retrofit.ApiService

class EmployeeRepository(private val api: ApiService) {
    suspend fun getEmployee() = api.getEmployeeData().data
}