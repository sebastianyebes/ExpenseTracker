package com.expense.backend.Model;

import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {
    
    public ExpenseResponseDto toResponseDto(Expense expense){
        ExpenseResponseDto responseDto = new ExpenseResponseDto();

        if(expense == null){
            return null;
        }

        responseDto.setId(expense.getId());
        responseDto.setTitle(expense.getTitle());
        responseDto.setAmount(expense.getAmount());
        responseDto.setCategory(expense.getCategory());
        responseDto.setDate(expense.getDate());
        responseDto.setCreatedAt(expense.getCreatedAt());

        return responseDto;
    }

    public Expense toEntity(ExpenseRequestDto dto){
        Expense expense = new Expense();
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDate(dto.getDate());
        expense.setCreatedAt(dto.getCreatedAt());
        return expense;
    }
}
