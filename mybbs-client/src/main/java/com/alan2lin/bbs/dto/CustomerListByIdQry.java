package com.alan2lin.bbs.dto;

import com.alibaba.cola.dto.Query;
import lombok.Data;

@Data
public class CustomerListByIdQry extends Query{
   private String id;
}
