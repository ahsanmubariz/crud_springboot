package com.testcrudspring.demo.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.testcrudspring.demo.models.Siswa;
import com.testcrudspring.demo.services.SiswaService;
import com.testcrudspring.demo.repositories.SiswaRepositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class SiswaServiceImpl implements SiswaService {

    SiswaRepositories siswarepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public SiswaServiceImpl(SiswaRepositories siswarepo) {
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
        std.setPassword(passEncode(std.getPassword()));
        return siswarepo.save(std);
    }

    @Override
    public void deleteById(int id) {
        siswarepo.deleteById(id);
    }

    public String passEncode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

}
