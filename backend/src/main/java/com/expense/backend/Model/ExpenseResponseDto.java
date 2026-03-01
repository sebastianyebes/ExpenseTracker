package com.expense.backend.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@JsonPropertyOrder({ "id", "amount", "category", "createdAt", "date", "title" })
public class ExpenseResponseDto {
    private String id;
    private String title;
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private LocalDateTime createdAt;
}
