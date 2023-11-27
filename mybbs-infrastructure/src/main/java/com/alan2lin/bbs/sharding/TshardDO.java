package com.alan2lin.bbs.sharding;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tshard")
public class TshardDO {
    @TableId(type =IdType.AUTO)
    Long id;

    String name;
    String value;
}
