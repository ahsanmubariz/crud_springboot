package com.testcrudspring.demo.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetSiswaResponse {
    private String message;
    private SiswaData data;
}
