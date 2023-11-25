package com.alan2lin.bbs.web;

import com.alan2lin.bbs.api.MytestServiceI;
import com.alan2lin.bbs.dto.*;
import com.alan2lin.bbs.dto.data.MytestDTO;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 适配器层 主要规范外部的调用方式， 比如多种不同的协议，web wap mq 等等。还负责业务数据到展示数据的渲染
 */
@RestController
public class MytestController {

    @Autowired
    private MytestServiceI mytestServiceI;

    @GetMapping(value = "/queryDirectly")
    public SingleResponse queryDirectly(@RequestParam String name){

        MytestByNameQry mytestByNameQry = new MytestByNameQry(name);
        return mytestServiceI.queryByNameDirectly(mytestByNameQry);
    }
    @GetMapping(value = "/queryDomain")
    public SingleResponse queryDomain(@RequestParam String name){

        MytestByNameQry mytestByNameQry = new MytestByNameQry(name);
        return mytestServiceI.queryByNameDomain(mytestByNameQry);
    }

    @PostMapping(value = "/appendDomain")
    public Response appendDomain(){
        MytestDTO mytestDTO = new MytestDTO(RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(5));
        MytestAddCmd mytestAddCmd = new MytestAddCmd(mytestDTO);
        return mytestServiceI.addMytestDirectly(mytestAddCmd);
    }
    @PostMapping(value = "/appendDirectly")
    public Response appendDirectly(){
        MytestDTO mytestDTO = new MytestDTO(RandomStringUtils.randomAlphabetic(5),RandomStringUtils.randomAlphabetic(5));
        MytestAddCmd mytestAddCmd = new MytestAddCmd(mytestDTO);
        return mytestServiceI.addMytestDirectly(mytestAddCmd);
    }

}
