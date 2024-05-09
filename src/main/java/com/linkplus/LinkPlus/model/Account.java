package com.linkplus.LinkPlus.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

@Entity
@Table(name="Account")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String accountNumber;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "userBank_id")
    private UserBank userBank;
}
