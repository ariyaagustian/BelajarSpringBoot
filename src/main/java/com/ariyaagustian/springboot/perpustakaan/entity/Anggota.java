package com.ariyaagustian.springboot.perpustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anggota")
public class Anggota {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "nama", nullable = false)
    private String nama;

    @Column(name = "nomor_ktp", nullable = false)
    private String nomor_ktp;

    @Column(name = "alamat")
    @Type(type = "text")
    private String alamat;
}
