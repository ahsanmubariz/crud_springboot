package com.testcrudspring.demo.controllers;

// import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testcrudspring.demo.exceptions.SiswaNotFoundException;
import com.testcrudspring.demo.models.Siswa;
import com.testcrudspring.demo.models.response.GetSiswaResponse;
import com.testcrudspring.demo.models.response.SiswaData;
import com.testcrudspring.demo.models.response.GetAllSiswaResponse;
// import com.testcrudspring.demo.models.response.SiswaData;
import com.testcrudspring.demo.services.impl.SiswaServiceImpl;

@RestController
@RequestMapping("/api")
public class SiswaController {
    SiswaServiceImpl siswaService;

    public SiswaController(SiswaServiceImpl siswaService) {
        this.siswaService = siswaService;
    }

    @GetMapping(value = "/siswa")
    public @ResponseBody ResponseEntity<Object> getAllStudents() {
        GetAllSiswaResponse resp = siswaService.getAll();
        return new ResponseEntity<Object>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/siswa/{id}")
    public @ResponseBody ResponseEntity<Object> getSiswaById(@PathVariable("id") @Min(1) int id) {
        GetSiswaResponse std = siswaService.getById(id);
        if (std.getData() == null) {
            return new ResponseEntity<Object>(std, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Object>(std, HttpStatus.OK);

        }
    }

    @GetMapping(value = "/siswa/email/{email}")
    public @ResponseBody ResponseEntity<Object> getSiswaByEmail(@PathVariable String email) {
        GetSiswaResponse std = siswaService.getByEmail(email);
        if (std.getData() == null) {
            return new ResponseEntity<Object>(std, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Object>(std, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/siswa")
    public @ResponseBody ResponseEntity<Object> addSiswa(@Valid @RequestBody Siswa std) {
        Siswa save = siswaService.save(std);
        SiswaData newSiswa = new SiswaData();

        newSiswa.setEmail(save.getEmail());
        newSiswa.setFirstname(save.getFirstname());
        newSiswa.setLastname(save.getLastname());
        newSiswa.setEmail(save.getEmail());
        newSiswa.setId(save.getId());
        return new ResponseEntity<Object>(newSiswa, HttpStatus.OK);
    }

    @PutMapping(value = "/siswa/{id}")
    public @ResponseBody ResponseEntity<Object> updateSiswa(@PathVariable("id") @Min(1) int id,
            @Valid @RequestBody Siswa newstd) {
        Siswa stdu = siswaService.findById(id).orElse(null);
        if (stdu == null) {
            return new ResponseEntity<Object>(null, HttpStatus.NOT_FOUND);
        }
        stdu.setFirstname(newstd.getFirstname());
        stdu.setLastname(newstd.getLastname());
        stdu.setEmail(newstd.getEmail());
        Siswa save = siswaService.save(stdu);

        SiswaData respData = new SiswaData();
        respData.setEmail(save.getEmail());
        respData.setFirstname(save.getFirstname());
        respData.setLastname(save.getLastname());
        respData.setEmail(save.getEmail());
        respData.setId(save.getId());

        GetSiswaResponse resp = new GetSiswaResponse();
        resp.setMessage("success");
        resp.setData(respData);
        // resp.setData();

        return new ResponseEntity<Object>(resp, HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/siswa/{id}")
    public @ResponseBody ResponseEntity<Object> deleteSiswa(@PathVariable("id") @Min(1) int id) {
        Siswa std = siswaService.findById(id).orElse(null);
        if (std == null) {
            return new ResponseEntity<Object>(std, HttpStatus.NOT_FOUND);
        } else {
            siswaService.deleteById(std.getId());

            GetSiswaResponse resp = new GetSiswaResponse();
            resp.setMessage("success");

            return new ResponseEntity<Object>(resp, HttpStatus.OK);
        }
        // return "Siswa with ID :" + id + " is deleted";
    }
}
