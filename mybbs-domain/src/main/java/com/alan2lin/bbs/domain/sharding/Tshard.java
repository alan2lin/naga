package com.alan2lin.bbs.domain.sharding;

import com.alibaba.cola.domain.Entity;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 领域类， 被标记Entity注解。其scrope不是singleton而是proto_ype,每次请求都是新实例
 */
@Data
@Slf4j
@Entity
public class Tshard {
    String name;
    String value;
    String domainSpec;

}
