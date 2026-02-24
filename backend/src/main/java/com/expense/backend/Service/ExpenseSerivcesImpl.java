package com.expense.backend.Service;

import java.util.List;

import com.expense.backend.Repository.ExpenseRepository;

public class ExpenseSerivcesImpl implements ExpenseServices {
        
    private final ExpenseRepository expenseRepository;

    public ExpenseSerivcesImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<String> getAllExpenses() {
        return expenseRepository.findAll().stream().map(expense -> expense.getTitle()).toList();
    }
}
