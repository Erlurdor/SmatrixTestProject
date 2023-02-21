package ru.erlurdor.TestProject.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository <Transaction, Integer> {
    Page<Transaction> findAllByClientId(int id, Pageable pageable);
}
