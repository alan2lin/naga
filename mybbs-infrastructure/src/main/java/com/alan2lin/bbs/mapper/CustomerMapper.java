package com.alan2lin.bbs.mapper;

import com.alan2lin.bbs.customer.CustomerDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface CustomerMapper extends BaseMapper<CustomerDO> {

  CustomerDO getByXXX(@Param("id") String customerId);

  /**
   * 自定义分页
   */
  IPage<CustomerDO> queryUserPage(@Param("page") IPage<CustomerDO> page);
}
