package com.linkplus.LinkPlus.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="UserBank")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UserBank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;

    @OneToMany(mappedBy = "userBank")
    private List<Account> Account;
}
