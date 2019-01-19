package com.ariyaagustian.springboot.perpustakaan.controller;

import com.ariyaagustian.springboot.perpustakaan.entity.Anggota;
import com.ariyaagustian.springboot.perpustakaan.entity.Penerbit;
import com.ariyaagustian.springboot.perpustakaan.repository.AnggotaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/anggota")
public class AnggotaApi {

    @Autowired
    private AnggotaRepository anggotaRepository;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/list")
    public Iterable<Anggota> findAll() {
        return anggotaRepository.findAll();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<Anggota> save(Principal principal, @RequestBody Anggota anggota) {
        anggota.setCreatedBy(principal.getName());
        anggota.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        anggota = anggotaRepository.save(anggota);
        log.info("{}", anggota);
        return ResponseEntity.ok(anggota);
    }


    @PostAuthorize("hasRole('ADMIN')")
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
