package com.expense.backend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.backend.Model.Expense;
import com.expense.backend.Model.ExpenseRequestDto;
import com.expense.backend.Model.ExpenseResponseDto;
import com.expense.backend.Service.ExpenseService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "http://localhost:5173") // Allow requests from the frontend the fastest way to enable CORS for the entire controller
public class ExpenseController {

    private final ExpenseService expenseService;    

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<ExpenseResponseDto>> getallExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseResponseDto> getExpense(@PathVariable String id) {
        ExpenseResponseDto expense = expenseService.getExpenseById(id);

        if(expense != null){
            return ResponseEntity.ok(expense);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Expense> saveExpense(@RequestBody ExpenseRequestDto expense) {
        return ResponseEntity.ok(expenseService.saveExpense(expense));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable String id, @RequestBody Expense expense) {
        Boolean isUpdated = expenseService.updateExpense(id, expense);

        if(isUpdated){
            return ResponseEntity.ok("Expense updated successfully");
        }

        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> patchExpense(@PathVariable String id, @RequestBody Expense expense) {
        Boolean isUpdated = expenseService.PatchExpense(id, expense);

        if(isUpdated){
            return ResponseEntity.ok("Expense updated successfully");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable String id){
        Boolean isDeleted = expenseService.deleteExpense(id);

        if(isDeleted){
            return ResponseEntity.ok("Expense deleted successfully");
        }

        return ResponseEntity.notFound().build();
    }
}