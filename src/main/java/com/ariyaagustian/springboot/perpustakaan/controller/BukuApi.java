package com.ariyaagustian.springboot.perpustakaan.controller;

import com.ariyaagustian.springboot.perpustakaan.entity.Buku;
import com.ariyaagustian.springboot.perpustakaan.repository.BukuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/buku")
public class BukuApi {

    @Autowired
    private BukuRepository bukuRepository;


    @GetMapping("/list")
    public Iterable<Buku> findAll() {
        return bukuRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Buku> save(@RequestBody Buku buku) {
        buku = bukuRepository.save(buku);
        return ResponseEntity.ok(buku);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buku> findById(@PathVariable("id") String id) {
        Optional<Buku> bukuOptional = bukuRepository.findById(id);
        if (bukuOptional.isPresent()) {
            return ResponseEntity.ok(bukuOptional.get());
        } else return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Buku> deleteById(@PathVariable("id") String id) {
        Optional<Buku> bukuOptional = bukuRepository.findById(id);
        if (bukuOptional.isPresent()) {
            bukuRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.noContent().build();
    }
}