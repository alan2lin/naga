
package com.alan2lin.bbs.sharding;


import com.alan2lin.bbs.domain.sharding.Tshard;
import com.alan2lin.bbs.domain.sharding.TshardGateway;
import com.alan2lin.bbs.dto.ShardingByIdQry;
import com.alan2lin.bbs.dto.data.TshardDTO;
import com.alibaba.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * 直接调用 基础层的存储
 */
@Component
public class ShardingQryCmdExe {

    @Resource
    TshardGateway shardingGateway;

    public SingleResponse<TshardDTO> execute(ShardingByIdQry cmd) {

        Tshard tshard= shardingGateway.queryById(cmd.getId());
        TshardDTO tshardDTO= new TshardDTO();
        BeanUtils.copyProperties(tshard,tshardDTO);
        return SingleResponse.of(tshardDTO);
    }

}
