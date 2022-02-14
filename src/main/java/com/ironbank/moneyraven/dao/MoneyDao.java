package com.ironbank.moneyraven.dao;

import com.ironbank.moneyraven.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyDao extends JpaRepository<Bank, String> {
}
