package com.ariyaagustian.springboot.perpustakaan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buku")
public class Buku {

    @Id
    @GenericGenerator(name = "uuid_gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid_gen")
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "judul", nullable = false)
    private String judul;

    @Type(type = "text")
    @Column(name = "deskripsi", nullable = false)
    private String deskripsi;

    @ManyToOne
    @JoinColumn(name = "penerbit_id", nullable = false)
    private Penerbit penerbit;

    @ManyToOne
    @JoinColumn(name = "pengarang_id", nullable = false)
    private Pengarang pengarang;
}
