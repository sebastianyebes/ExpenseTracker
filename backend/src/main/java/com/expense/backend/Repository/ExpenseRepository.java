package com.expense.backend.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.expense.backend.Model.Expense;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    
}
