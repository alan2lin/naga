package com.alan2lin.bbs.mytest;

import com.alan2lin.bbs.domain.mytest.Mytest;
import com.alan2lin.bbs.domain.mytest.gateway.MytestGateway;
import com.alan2lin.bbs.mapper.MytestMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class MytestGatewayImpl implements MytestGateway {

    @Resource
    MytestMapper mytestMapper;
    @Override
    public int save(Mytest mytest) {
        MytestDO mytestDO = new MytestDO();
        BeanUtils.copyProperties(mytest,mytestDO);
        return mytestMapper.insert(mytestDO);
    }

    @Override
    public Mytest queryByName(String name) {
        QueryWrapper<MytestDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",name);

        MytestDO  mytestDO = mytestMapper.selectOne(queryWrapper);

        Mytest mytest = new Mytest();
        BeanUtils.copyProperties(mytestDO,mytest);
        return mytest;
    }
}
