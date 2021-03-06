package com.ariyaagustian.springboot.perpustakaan.controller;

import com.ariyaagustian.springboot.perpustakaan.entity.Transaction;
import com.ariyaagustian.springboot.perpustakaan.repository.TransactionRepository;
import com.ariyaagustian.springboot.perpustakaan.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/transaction")
public class TransactionApi {

    @Autowired
    private TransactionService service;

    @GetMapping("/list")
    public Iterable<Transaction> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable("id") String id) {
        Optional<Transaction> transactionOptional = service.findById(id);
        if (transactionOptional.isPresent())
            return ResponseEntity.ok(transactionOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @PostMapping("/peminjaman")
    public ResponseEntity<Transaction> peminjamanBuku(
            @RequestBody Transaction transaction) {
        transaction = service.penjamBuku(transaction);
        return ResponseEntity.ok(transaction);
    }
}