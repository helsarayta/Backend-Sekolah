package com.heydie.sekolah.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pengguna {
    private Integer id;
    private String nama;
    private String alamat;
    private String kategori;
    private Integer idSekolah;
}
