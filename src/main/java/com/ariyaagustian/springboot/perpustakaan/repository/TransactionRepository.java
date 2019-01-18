package com.ariyaagustian.springboot.perpustakaan.repository;

import com.ariyaagustian.springboot.perpustakaan.entity.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
}
