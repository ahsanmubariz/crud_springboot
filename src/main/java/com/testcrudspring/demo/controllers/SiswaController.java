package com.testcrudspring.demo.controllers;

import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testcrudspring.demo.exceptions.SiswaNotFoundException;
import com.testcrudspring.demo.models.Siswa;
import com.testcrudspring.demo.services.impl.SiswaServiceImpl;

@RestController
@RequestMapping("/api")
public class SiswaController {
    SiswaServiceImpl siswaService;

    public SiswaController(SiswaServiceImpl siswaService) {
        this.siswaService = siswaService;
    }

    @GetMapping(value = "/siswa")
    public List<Siswa> getAllStudents() {
        return siswaService.getAllSiswa();
    }

    @GetMapping(value = "/siswa/{id}")
    public Siswa getSiswaById(@PathVariable("id") @Min(1) int id) {
        Siswa std = siswaService.findById(id)
                .orElseThrow(() -> new SiswaNotFoundException("Siswa with " + id + " is Not Found!"));
        return std;
    }

    @GetMapping(value = "/siswa/email{email}")
    public Siswa getSiswaByEmail(@PathVariable String email) {
        Siswa std = siswaService.findByEmail(email)
                .orElseThrow(() -> new SiswaNotFoundException("Siswa with " + email + " is Not Found!"));
        return std;
    }

    @PostMapping(value = "/siswa")
    public Siswa addSiswa(@Valid @RequestBody Siswa std) {
        return siswaService.save(std);
    }

    @PutMapping(value = "/siswa/{id}")
    public Siswa updateSiswa(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Siswa newstd) {
        Siswa stdu = siswaService.findById(id)
                .orElseThrow(() -> new SiswaNotFoundException("Siswa with " + id + " is Not Found!"));
        stdu.setFirstname(newstd.getFirstname());
        stdu.setLastname(newstd.getLastname());
        stdu.setEmail(newstd.getEmail());
        return siswaService.save(stdu);
    }

    @DeleteMapping(value = "/siswa/{id}")
    public String deleteSiswa(@PathVariable("id") @Min(1) int id) {
        Siswa std = siswaService.findById(id)
                .orElseThrow(() -> new SiswaNotFoundException("Siswa with " + id + " is Not Found!"));
        siswaService.deleteById(std.getId());
        return "Siswa with ID :" + id + " is deleted";
    }
}
