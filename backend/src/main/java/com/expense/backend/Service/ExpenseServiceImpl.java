package com.expense.backend.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.expense.backend.Model.Expense;
import com.expense.backend.Model.ExpenseMapper;
import com.expense.backend.Model.ExpenseRequestDto;
import com.expense.backend.Model.ExpenseResponseDto;
import com.expense.backend.Repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
        
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
    }

    public List<ExpenseResponseDto> getAllExpenses() {
        return expenseRepository.findAll().stream().map(expenseMapper::toResponseDto).toList();
    }

    public ExpenseResponseDto getExpenseById(String id) {
        return expenseRepository.findById(id).map(expenseMapper::toResponseDto).orElse(null);
    }

    public Expense saveExpense(ExpenseRequestDto expense) {
        Expense newExpense = expenseMapper.toEntity(expense);
        newExpense.setDate(expense.getDate() != null ? expense.getDate() : java.time.LocalDate.now());
        newExpense.setCreatedAt(expense.getCreatedAt() != null ? expense.getCreatedAt() : java.time.LocalDateTime.now());
        return expenseRepository.save(newExpense);
    }

    public Boolean updateExpense(String id, Expense expense) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);
        
        if(existingExpense == null){
            return false;
        }

        existingExpense.setTitle(expense.getTitle());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setCategory(expense.getCategory());
        existingExpense.setDate(expense.getDate());

        expenseRepository.save(existingExpense);
        return true;
    }

    public Boolean PatchExpense(String id, Expense expense) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);
        
        if(existingExpense == null){
            return false;
        }

        if(expense.getTitle() != null){
            existingExpense.setTitle(expense.getTitle());
        }

        if(expense.getAmount() != null){
            existingExpense.setAmount(expense.getAmount());
        }

        if(expense.getCategory() != null){
            existingExpense.setCategory(expense.getCategory());
        }

        if(expense.getDate() != null){
            existingExpense.setDate(expense.getDate());
        }

        expenseRepository.save(existingExpense);
        return true;
    }

    public Boolean deleteExpense(String id) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);
        
        if(existingExpense == null){
            return false;
        }

        expenseRepository.delete(existingExpense);
        return true;
    }
}
