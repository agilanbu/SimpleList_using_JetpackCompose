package com.example.simplelist.model

import com.google.gson.annotations.SerializedName

data class Employee(
    @SerializedName("id") val id: Int,
    @SerializedName("employee_name") val empName: String,
    @SerializedName("employee_salary") val empSalary: Int,
    @SerializedName("employee_age") val empAge: Int,
    @SerializedName("profile_image") val profileImage: String
)