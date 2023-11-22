package com.alan2lin.bbs.customer;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CustomerMapper{

  CustomerDO getByXXX(@Param("id") String customerId);
}
