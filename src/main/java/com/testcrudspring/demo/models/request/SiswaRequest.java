package com.testcrudspring.demo.models.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class SiswaRequest {
    @NotNull
    private int id;
}
