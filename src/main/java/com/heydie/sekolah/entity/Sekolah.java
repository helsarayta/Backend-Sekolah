package com.heydie.sekolah.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sekolah {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSekolah;
    private String nama;
    private String alamat;
}
