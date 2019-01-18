package com.ariyaagustian.springboot.perpustakaan.controller;

import com.ariyaagustian.springboot.perpustakaan.entity.Anggota;
import com.ariyaagustian.springboot.perpustakaan.entity.Penerbit;
import com.ariyaagustian.springboot.perpustakaan.entity.Pengarang;
import com.ariyaagustian.springboot.perpustakaan.repository.PengarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api/pengarang")
public class PengarangApi {

    @Autowired
    private PengarangRepository pengarangRepository;

    @GetMapping("/list")
    public Iterable<Pengarang> findAll() {
        return pengarangRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Pengarang> save(
            @RequestBody Pengarang pengarang) {
        pengarang = pengarangRepository.save(pengarang);
        return ResponseEntity.ok(pengarang);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Pengarang> findById(
            @PathVariable("id") String pengarangId) {
        Optional<Pengarang> pengarangOptional = pengarangRepository.findById(pengarangId);
        if (pengarangOptional.isPresent())
            return ResponseEntity.ok(pengarangOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pengarang> deleteById(@PathVariable("id") String id) {
        pengarangRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}