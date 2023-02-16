package com.testcrudspring.demo.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.testcrudspring.demo.models.Siswa;
import com.testcrudspring.demo.models.response.GetAllSiswaResponse;
import com.testcrudspring.demo.models.response.GetSiswaResponse;
import com.testcrudspring.demo.models.response.SiswaData;
import com.testcrudspring.demo.repositories.SiswaRepositories;
import com.testcrudspring.demo.services.SiswaService;

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

    public GetAllSiswaResponse getAll() {
        GetAllSiswaResponse response = new GetAllSiswaResponse();
        List<Siswa> allSiswa = getAllSiswa();
        List<SiswaData> tempSiswaList = new ArrayList<SiswaData>();

        allSiswa.forEach((data) -> {
            SiswaData siswaTemp = new SiswaData();
            siswaTemp.setEmail(data.getEmail());
            siswaTemp.setId(data.getId());
            siswaTemp.setFirstname(data.getFirstname());
            siswaTemp.setLastname(data.getLastname());
            tempSiswaList.add(siswaTemp);
        });
        response.setData(tempSiswaList);
        response.setMessage("success");
        // response.setListSiswa(getAllSiswa());
        return response;
    }

    @Override
    public Optional<Siswa> findById(int id) {
        return siswarepo.findById(id);
    }

    public GetSiswaResponse getById(int id) {
        GetSiswaResponse response = new GetSiswaResponse();
        SiswaData siswaMapped = new SiswaData();
        Optional<Siswa> siswa = findById(id);

        if (siswa.isPresent()) {
            Siswa siswaResult = siswa.get();
            siswaMapped.setEmail(siswaResult.getEmail());
            siswaMapped.setId(siswaResult.getId());
            siswaMapped.setFirstname(siswaResult.getFirstname());
            siswaMapped.setLastname(siswaResult.getLastname());
            response.setData(siswaMapped);
            response.setMessage("success");

        } else {
            response.setMessage("failed");
        }
        return response;
    }

    @Override
    public Optional<Siswa> findByEmail(String email) {
        return siswarepo.findByEmail(email);
    }

    public GetSiswaResponse getByEmail(String email) {
        GetSiswaResponse response = new GetSiswaResponse();
        SiswaData siswaMapped = new SiswaData();
        Optional<Siswa> siswa = findByEmail(email);

        if (siswa.isPresent()) {
            Siswa siswaResult = siswa.get();
            siswaMapped.setEmail(siswaResult.getEmail());
            siswaMapped.setId(siswaResult.getId());
            siswaMapped.setFirstname(siswaResult.getFirstname());
            siswaMapped.setLastname(siswaResult.getLastname());
            response.setData(siswaMapped);
            response.setMessage("success");

        } else {
            response.setMessage("failed");
        }
        return response;
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
