package com.alan2lin.bbs.dto;

import com.alan2lin.bbs.dto.data.CustomerDTO;
import com.alan2lin.bbs.dto.data.MytestDTO;
import lombok.Data;

@Data
public class MytestAddCmd {

    private MytestDTO mytestDTO;

    public MytestAddCmd(MytestDTO mytestDTO) {
        this.mytestDTO = mytestDTO;
    }
}
