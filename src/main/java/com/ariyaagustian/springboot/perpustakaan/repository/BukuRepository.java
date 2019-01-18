package com.ariyaagustian.springboot.perpustakaan.repository;

import com.ariyaagustian.springboot.perpustakaan.entity.Buku;
import org.springframework.data.repository.CrudRepository;

public interface BukuRepository extends CrudRepository<Buku, String> {
}
