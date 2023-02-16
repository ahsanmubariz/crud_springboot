package com.testcrudspring.demo.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiswaData {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
}
