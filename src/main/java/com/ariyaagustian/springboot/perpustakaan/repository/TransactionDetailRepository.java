package com.ariyaagustian.springboot.perpustakaan.repository;

import com.ariyaagustian.springboot.perpustakaan.entity.TransactionDetail;
import org.springframework.data.repository.CrudRepository;

public interface TransactionDetailRepository extends CrudRepository<TransactionDetail, String> {
}
