package com.alan2lin.bbs.dto;

import com.alibaba.cola.dto.Query;
import lombok.Data;

@Data
public class MytestByNameQry extends Query{
   private String name;

   public MytestByNameQry(String name) {
      this.name = name;
   }
}
