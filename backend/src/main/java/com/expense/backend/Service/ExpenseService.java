package com.expense.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.backend.Model.Expense;
import com.expense.backend.Model.ExpenseRequestDto;
import com.expense.backend.Model.ExpenseResponseDto;

@Service
public interface ExpenseService {
    public List<ExpenseResponseDto> getAllExpenses();    
    public ExpenseResponseDto getExpenseById(String id);
    public Expense saveExpense(ExpenseRequestDto expense);
    public Boolean updateExpense(String id, Expense expense);
    public Boolean PatchExpense(String id, Expense expense);
    public Boolean deleteExpense(String id);
}
