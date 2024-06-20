package com.example.simplelist.retrofit

import com.example.simplelist.model.Employee
import com.example.simplelist.model.EmployeeResponse
import retrofit2.http.GET


interface ApiService {
    @GET("api/v1/employees")
    suspend fun getEmployeeData(): EmployeeResponse
}