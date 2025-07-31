package com.codingrecipe.uigunlee.company.entity;

import com.codingrecipe.uigunlee.account.entity.Account;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;
    private String business;
    private String ceoName;
    private int companyNum;

    public Company(String companyName, String business, String ceoName, int companyNum) {
        this.companyName = companyName;
        this.business = business;
        this.ceoName = ceoName;
        this.companyNum = companyNum;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Company(String companyName, String business, String ceoName, int companyNum, Account account) {
        this.companyName = companyName;
        this.business = business;
        this.ceoName = ceoName;
        this.companyNum = companyNum;
        this.account = account;
    }
}
