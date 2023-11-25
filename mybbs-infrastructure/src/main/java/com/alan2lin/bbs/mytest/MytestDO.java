package com.alan2lin.bbs.mytest;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("test")
public class MytestDO {
    @TableId(type =IdType.AUTO)
    Long id;

    String name;
    String value;
}
