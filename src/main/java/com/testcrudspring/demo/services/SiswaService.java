package com.testcrudspring.demo.services;

import java.util.List;
import java.util.Optional;

import com.testcrudspring.demo.models.Siswa;
import com.testcrudspring.demo.models.response.GetSiswaResponse;
import com.testcrudspring.demo.models.response.GetAllSiswaResponse;

public interface SiswaService {
    List<Siswa> getAllSiswa();

    GetAllSiswaResponse getAll();

    GetSiswaResponse getById(int id);

    GetSiswaResponse getByEmail(String email);

    Optional<Siswa> findById(int id);

    Optional<Siswa> findByEmail(String email);

    Siswa save(Siswa std);

    // GetSiswaResponse create(SiswaData std);

    void deleteById(int id);

}
