package com.test_crud_spring.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.test_crud_spring.demo.models.Siswa;
import com.test_crud_spring.demo.dto.SiswaView;
import com.test_crud_spring.demo.repositories.SiswaRepositories;

@Service
public class SiswaService implements ISiswa {
    SiswaRepositories siswarepo;

    public SiswaService(SiswaRepositories siswarepo) {
        this.siswarepo = siswarepo;
    }

    @Override
    public List<Siswa> getAllSiswa() {
        return siswarepo.findAll();
    }

    @Override
    public Optional<Siswa> findById(int id) {
        return siswarepo.findById(id);
    }

    @Override
    public Optional<Siswa> findByEmail(String email) {
        return siswarepo.findByEmail(email);
    }

    @Override
    public Siswa save(Siswa std) {
        return siswarepo.save(std);
    }

    @Override
    public void deleteById(int id) {
        siswarepo.deleteById(id);
    }

}
