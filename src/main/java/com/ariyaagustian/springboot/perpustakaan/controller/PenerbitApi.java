package com.ariyaagustian.springboot.perpustakaan.controller;


import com.ariyaagustian.springboot.perpustakaan.entity.Anggota;
import com.ariyaagustian.springboot.perpustakaan.entity.Penerbit;
import com.ariyaagustian.springboot.perpustakaan.repository.PenerbitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/penerbit")
public class PenerbitApi {

    @Autowired
    private PenerbitRepository penerbitRepository;


    @GetMapping("/list")
    public Iterable<Penerbit> findAll() {
        return penerbitRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Penerbit> save(
            @RequestBody Penerbit penerbit) {
        penerbit = penerbitRepository.save(penerbit);
        return ResponseEntity.ok(penerbit);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Penerbit> findById(
            @PathVariable("id") String penerbitId) {
        Optional<Penerbit> penerbitOptional = penerbitRepository.findById(penerbitId);
        if (penerbitOptional.isPresent())
            return ResponseEntity.ok(penerbitOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Penerbit> deleteById(@PathVariable("id") String id) {
        penerbitRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
