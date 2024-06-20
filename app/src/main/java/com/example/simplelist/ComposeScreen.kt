package com.example.simplelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplelist.model.Employee
import com.example.simplelist.viewmodel.EmployeeViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*


@Composable
fun EmployeeListScreen(viewModel: EmployeeViewModel ) {
    val employeeList by viewModel.emplist.observeAsState(emptyList())

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(employeeList) { employee ->
            EmployeeItem(employee)
        }
    }
}


@Composable
fun EmployeeItem(employee: Employee) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name: ${employee.empName}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Age: ${employee.empAge}", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Salary: ${employee.empSalary}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
