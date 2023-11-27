package com.alan2lin.bbs.api;

import com.alan2lin.bbs.dto.ShardingByIdQry;
import com.alan2lin.bbs.dto.data.TshardDTO;
import com.alibaba.cola.dto.SingleResponse;

/**
 * client是整个领域服务对外暴露的接口。还负责业务数据转换
 */
public interface ShardingServiceI {
    SingleResponse<TshardDTO> queryByIdDirectly(ShardingByIdQry shardingByIdQry);
}
