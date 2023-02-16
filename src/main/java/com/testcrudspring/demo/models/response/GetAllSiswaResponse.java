package com.testcrudspring.demo.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllSiswaResponse {

    private String message;
    private List<SiswaData> data;
}
