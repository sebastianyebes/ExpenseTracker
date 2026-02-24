package com.expense.backend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.backend.Service.ExpenseServices;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseServices expenseServices;

    public ExpenseController(ExpenseServices expenseServices) {
        this.expenseServices = expenseServices;
    }

    @GetMapping("")
    public ResponseEntity<List<String>> getallExpenses() {
        return new ResponseEntity<>(expenseServices.getAllExpenses(), HttpStatus.OK);
    }
    
}
