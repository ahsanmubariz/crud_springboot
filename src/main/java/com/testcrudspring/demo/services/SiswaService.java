package com.testcrudspring.demo.services;

import java.util.List;
import java.util.Optional;

import com.testcrudspring.demo.models.Siswa;

public interface SiswaService {
    List<Siswa> getAllSiswa();

    Optional<Siswa> findById(int id);

    Optional<Siswa> findByEmail(String email);

    Siswa save(Siswa std);

    void deleteById(int id);

}
