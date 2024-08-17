package com.heydie.sekolah.controller;

import com.heydie.sekolah.entity.Sekolah;
import com.heydie.sekolah.model.Pengguna;
import com.heydie.sekolah.service.SekolahService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sekolah")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SekolahController {

    private final SekolahService sekolahService;

    @GetMapping("/all")
    public ResponseEntity<List<Sekolah>> findAll() {
        return new ResponseEntity<>(sekolahService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Sekolah> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(sekolahService.findById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Sekolah> create(@RequestBody Sekolah sekolah) {
        return new ResponseEntity<>(sekolahService.create(sekolah), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Sekolah> update(@RequestBody Sekolah sekolah, @PathVariable("id") Integer id) {
        return new ResponseEntity<>(sekolahService.update(sekolah, id), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(sekolahService.delete(id), HttpStatus.OK);
    }

    @PostMapping("/find-pengguna/{id}")
    public ResponseEntity<List<Pengguna>> findPenggunaByIdSekolah(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(sekolahService.getPenggunaBySekolahId(id), HttpStatus.OK);
    }

}
