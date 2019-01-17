package com.ariyaagustian.springboot.perpustakaan.repository;

import com.ariyaagustian.springboot.perpustakaan.entity.Pengarang;
import org.springframework.data.repository.CrudRepository;

public interface PengarangRepository extends CrudRepository<Pengarang, String> {
}
