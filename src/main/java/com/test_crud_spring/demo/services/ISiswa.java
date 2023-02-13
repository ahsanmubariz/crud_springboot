package com.test_crud_spring.demo.services;

import java.util.List;
import java.util.Optional;
import com.test_crud_spring.demo.models.Siswa;

public interface ISiswa {
    List<Siswa> getAllSiswa();

    Optional<Siswa> findById(int id);

    Optional<Siswa> findByEmail(String email);

    Siswa save(Siswa std);

    void deleteById(int id);

}
