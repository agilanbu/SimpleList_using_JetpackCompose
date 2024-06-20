package com.example.simplelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.simplelist.repository.EmployeeRepository
import com.example.simplelist.retrofit.RetrofitInstance
import com.example.simplelist.viewmodel.EmpViewModelFactory
import com.example.simplelist.viewmodel.EmployeeViewModel

class MainActivity : ComponentActivity() {
    private lateinit var empViewModel: EmployeeViewModel
    private lateinit var repository: EmployeeRepository
    private lateinit var viewModelFactory: EmpViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repository = EmployeeRepository(RetrofitInstance.api)
        viewModelFactory = EmpViewModelFactory(repository)
        empViewModel = ViewModelProvider(this, viewModelFactory)[EmployeeViewModel::class.java]
        setContent {
            EmployeeListScreen(empViewModel)
        }

    }
}

