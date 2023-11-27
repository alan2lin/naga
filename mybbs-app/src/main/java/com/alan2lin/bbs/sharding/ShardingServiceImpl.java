package com.alan2lin.bbs.sharding;

import com.alan2lin.bbs.api.ShardingServiceI;
import com.alan2lin.bbs.dto.ShardingByIdQry;
import com.alan2lin.bbs.dto.data.TshardDTO;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * app层 负责 业务的编排，负责将本领域对象，本领域服务和其他的领域服务或其他的服务整合，形成一个完整的业务输出。
 * 对下可能调用到 domain层服务， 以及infrastructure层。
 * 上下文的映射，是否应该在此层得到实现呢? 待确定
 */

@Service
@CatchAndLog
public class ShardingServiceImpl implements ShardingServiceI {


    @Resource
    ShardingQryCmdExe shardingQryCmdExe;

    @Override
    public SingleResponse<TshardDTO> queryByIdDirectly(ShardingByIdQry shardingByIdQry) {
        //服务编排 or 直接调用领域service

        return  shardingQryCmdExe.execute(shardingByIdQry);

    }

}