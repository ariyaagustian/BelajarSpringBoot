package com.ariyaagustian.springboot.perpustakaan.controller;

import com.ariyaagustian.springboot.perpustakaan.entity.Pengarang;
import com.ariyaagustian.springboot.perpustakaan.repository.PengarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pengarang")
public class PengarangApi {

    @Autowired
    private PengarangRepository repository;

    @GetMapping("/list")
    public Iterable<Pengarang> findAll() {
        return repository.findAll();
    }
}