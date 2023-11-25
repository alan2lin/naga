
package com.alan2lin.bbs.mytest;


import com.alan2lin.bbs.domain.mytest.Mytest;
import com.alan2lin.bbs.domain.mytest.gateway.MytestGateway;
import com.alan2lin.bbs.dto.MytestAddCmd;
import com.alan2lin.bbs.dto.MytestByNameQry;
import com.alan2lin.bbs.dto.data.MytestDTO;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * 直接调用 基础层的存储
 */
@Component
public class MytestQryCmdExe {

    @Resource
    MytestGateway mytestGateway;

    public SingleResponse<MytestDTO> execute(MytestByNameQry cmd) {

        Mytest mytest = mytestGateway.queryByName(cmd.getName());
        MytestDTO mytestDTO = new MytestDTO();
        BeanUtils.copyProperties(mytest,mytestDTO);
        return SingleResponse.of(mytestDTO);
    }

}
