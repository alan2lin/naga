package com.alan2lin.bbs.dto;

import com.alibaba.cola.dto.Query;
import lombok.Data;

@Data
public class ShardingByIdQry extends Query{
   private Long id;

   public ShardingByIdQry(Long id) {
      this.id= id;
   }
}
