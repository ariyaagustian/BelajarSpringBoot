package com.ariyaagustian.springboot.perpustakaan.service;


import com.ariyaagustian.springboot.perpustakaan.entity.Transaction;
import com.ariyaagustian.springboot.perpustakaan.entity.TransactionDetail;
import com.ariyaagustian.springboot.perpustakaan.repository.TransactionDetailRepository;
import com.ariyaagustian.springboot.perpustakaan.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionDetailRepository transactionDetailRepository;

    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(String id) {
        return this.transactionRepository.findById(id);
    }

    @Transactional
    public Transaction penjamBuku(Transaction transaction) {
        List<TransactionDetail> newDetail = transaction.getDetails();
        transaction = transactionRepository.save(transaction);
        for (TransactionDetail details : newDetail) {
            details.setTransaction(transaction);
            transactionDetailRepository.save(details);
        }
        Optional<Transaction> transactionOptional = transactionRepository.findById(transaction.getId());
        return transactionOptional.get();
    }
}