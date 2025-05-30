package com.example.appfinanzas.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.appfinanzas.model.Expense

class FinanceViewModel : ViewModel() {
    private val _expenses = mutableStateListOf<Expense>()
    val expenses: List<Expense> = _expenses

    fun addExpense(description: String, amount: Double) {
        _expenses.add(Expense(description, amount))
    }
}