package com.alan2lin.bbs.domain.mytest.gateway;

import com.alan2lin.bbs.domain.mytest.Mytest;

public interface MytestGateway {

    public int save(Mytest mytest);

    public Mytest queryByName(String name);

}
