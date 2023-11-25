package com.alan2lin.bbs.dto.data;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MytestDTO {
    private String id;
    private String name;
    private String value;

    public MytestDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public MytestDTO() {
    }
}
