package com.heydie.sekolah.service;

import com.heydie.sekolah.entity.Sekolah;
import com.heydie.sekolah.model.Pengguna;
import com.heydie.sekolah.repository.SekolahRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SekolahService {

    private final SekolahRepository sekolahRepository;
    private final RestTemplate restTemplate;

    public List<Sekolah> getAll() {
        return sekolahRepository.findAll();
    }
    public Sekolah create(Sekolah sekolah) {
        return sekolahRepository.save(sekolah);
    }

    public Sekolah findById(Integer id) {
        return sekolahRepository.findById(id).orElseThrow(() -> new RuntimeException("Sekolah with id " + id + " not found"));
    }

    public Sekolah update(Sekolah sekolah, Integer id) {
        Sekolah byId = findById(id);

        byId.setAlamat(sekolah.getAlamat());
        byId.setNama(sekolah.getNama());

        return sekolahRepository.save(byId);
    }

    public String delete(Integer id) {
        Sekolah byId = findById(id);
        sekolahRepository.delete(byId);
        return "Sekolah with id " + id + " deleted";
    }



    public List<Pengguna> getPenggunaBySekolahId(Integer id) {
        Pengguna[] forObject = restTemplate
                .getForObject("http://localhost:8081/api/v1/pengguna/findby-id-sekolah/" + id, Pengguna[].class);

        return Arrays.stream(forObject).collect(Collectors.toList());
    }
}
