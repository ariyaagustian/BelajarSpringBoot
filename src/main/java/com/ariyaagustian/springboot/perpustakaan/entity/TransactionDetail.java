package com.ariyaagustian.springboot.perpustakaan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "transaction_detail")
    public class TransactionDetail {

        @Id
        @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
        @GeneratedValue(generator = "uuid_gen")
        private String id;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "transaction_id", nullable = false)
        private Transaction transaction;

        @ManyToOne
        @JoinColumn(name = "buku_id", nullable = false)
        private Buku buku;

    }

