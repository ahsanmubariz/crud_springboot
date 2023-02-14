package com.testcrudspring.demo.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.testcrudspring.demo.models.Siswa;

public interface SiswaRepositories extends JpaRepository<Siswa, Integer> {
    Optional<Siswa> findByEmail(String email);
}
