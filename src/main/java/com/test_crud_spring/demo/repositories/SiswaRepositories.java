package com.test_crud_spring.demo.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test_crud_spring.demo.models.Siswa;

public interface SiswaRepositories extends JpaRepository<Siswa, Integer> {
    Optional<Siswa> findByEmail(String email);
}
