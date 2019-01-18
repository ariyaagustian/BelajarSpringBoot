package com.ariyaagustian.springboot.perpustakaan.controller;

import com.ariyaagustian.springboot.perpustakaan.entity.Anggota;
import com.ariyaagustian.springboot.perpustakaan.entity.Penerbit;
import com.ariyaagustian.springboot.perpustakaan.repository.AnggotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/anggota")
public class AnggotaApi {

    @Autowired
    private AnggotaRepository anggotaRepository;


    @GetMapping("/list")
    public Iterable<Anggota> findAll() {
        return anggotaRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Anggota> save(
            @RequestBody Anggota anggota) {
        anggota = anggotaRepository.save(anggota);
        return ResponseEntity.ok(anggota);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Anggota> findById(
            @PathVariable("id") String anggotaId) {
        Optional<Anggota> anggotaOptional = anggotaRepository.findById(anggotaId);
        if (anggotaOptional.isPresent())
            return ResponseEntity.ok(anggotaOptional.get());
        else
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Anggota> deleteById(@PathVariable("id") String id) {
        anggotaRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }




}
