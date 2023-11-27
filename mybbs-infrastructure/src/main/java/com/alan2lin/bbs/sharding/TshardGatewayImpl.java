package com.alan2lin.bbs.sharding;

import com.alan2lin.bbs.domain.sharding.Tshard;
import com.alan2lin.bbs.domain.sharding.TshardGateway;
import com.alan2lin.bbs.mapper.TshardMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TshardGatewayImpl implements TshardGateway {

    @Resource
    TshardMapper tshardMapper;


    @Override
    public Tshard queryById(Long id) {
        QueryWrapper<TshardDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);

        TshardDO tshardDO= tshardMapper.selectOne(queryWrapper);

        Tshard tshard = new Tshard();
        BeanUtils.copyProperties(tshardDO,tshard);
        return tshard;
    }
}
