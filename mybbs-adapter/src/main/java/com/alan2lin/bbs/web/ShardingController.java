package com.alan2lin.bbs.web;

import com.alan2lin.bbs.api.MytestServiceI;
import com.alan2lin.bbs.api.ShardingServiceI;
import com.alan2lin.bbs.dto.MytestAddCmd;
import com.alan2lin.bbs.dto.MytestByNameQry;
import com.alan2lin.bbs.dto.ShardingByIdQry;
import com.alan2lin.bbs.dto.data.MytestDTO;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 适配器层 主要规范外部的调用方式， 比如多种不同的协议，web wap mq 等等。还负责业务数据到展示数据的渲染
 */
@RestController
public class ShardingController {

    @Autowired
    private ShardingServiceI shardingServiceI;

    @GetMapping(value = "/querySharding")
    public SingleResponse querySharding(@RequestParam Long id){

        ShardingByIdQry shardingByIdQry = new ShardingByIdQry(id);
        return shardingServiceI.queryByIdDirectly(shardingByIdQry);
    }


}
