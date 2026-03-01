package com.expense.backend.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ExpenseRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    @NotNull(message = "Amount is required")
    private BigDecimal amount;
    
    private String category;
    private LocalDate date;
    private LocalDateTime createdAt;
}
