package com.codingrecipe.uigunlee.account.repository;

import com.codingrecipe.uigunlee.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository<Account, Long> {
}
