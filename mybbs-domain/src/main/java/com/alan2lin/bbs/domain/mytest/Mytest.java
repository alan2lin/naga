package com.alan2lin.bbs.domain.mytest;

import com.alan2lin.bbs.domain.mytest.gateway.MytestGateway;
import com.alibaba.cola.domain.ApplicationContextHelper;
import com.alibaba.cola.domain.Entity;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * 领域类， 被标记Entity注解。其scrope不是singleton而是proto_ype,每次请求都是新实例
 */
@Data
@Slf4j
@Entity
public class Mytest {

    @Resource
    MytestGateway mytestGateway;

    String name;
    String value;
    String domainSpec;

    public void doDomainLogicThenSave(){

        log.info(" do mytest domain logic, will saving mytestvo");
        mytestGateway.save(this);
    }
}
