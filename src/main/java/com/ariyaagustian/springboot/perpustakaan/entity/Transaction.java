package com.ariyaagustian.springboot.perpustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Type(type = "timestamp")
    @Column(name = "tanggal_pinjam", nullable = false)
    private Date tanggal_pinjam;

    @ManyToOne
    @JoinColumn(name = "anggota_id", nullable = false)
    private Anggota anggota;

    @Column(name = "kembali", nullable = false)
    private Boolean kembali;

    @Type(type = "date")
    @Column(name = "tanggal_kembali", nullable = false)
    private Date tanggal_kembali;

    @OneToMany(mappedBy = "transaction")
    public List<TransactionDetail> details = new ArrayList<>();

}