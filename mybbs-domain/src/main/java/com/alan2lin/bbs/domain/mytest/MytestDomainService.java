package com.alan2lin.bbs.domain.mytest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *领域服务类 ，某些行为无法归结为某一个领域类 ，就可以归为 领域服务类。
 * 用于处理领域类与领域类之间的关系， 或者是领域类与外部的领域类之间的关系。
 */


@Component
@Slf4j
public class MytestDomainService {

    public void appendMytestByDomainLogic(){
        log.info(" MytestDomainService append  do something ");
    }

    public void queryMytestByDomainLogic(){
        log.info(" MytestDomainService  query do something ");
    }


}
