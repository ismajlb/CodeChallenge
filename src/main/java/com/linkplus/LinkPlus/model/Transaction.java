package com.linkplus.LinkPlus.model;

import com.linkplus.LinkPlus.model.enums.TypesOfFees;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "From_Account")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "To_Account")
    private Account toAccount;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private String reason;

    @Enumerated(EnumType.STRING)
    private TypesOfFees typesOfFees;
}