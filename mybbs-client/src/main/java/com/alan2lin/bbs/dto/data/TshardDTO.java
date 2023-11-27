package com.alan2lin.bbs.dto.data;

import lombok.Data;

@Data
public class TshardDTO {
    private String id;
    private String name;
    private String value;

    public TshardDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public TshardDTO() {
    }
}
