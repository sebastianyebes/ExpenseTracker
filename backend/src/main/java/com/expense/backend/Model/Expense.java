package com.expense.backend.Model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Expense {
    
    @Id
    private Long id;

    private String title;
    private BigDecimal amount;
    private String category;
    private LocalDate date;
    private LocalDateTime createdAt;
}
