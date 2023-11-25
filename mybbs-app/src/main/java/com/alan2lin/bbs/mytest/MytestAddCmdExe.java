
package com.alan2lin.bbs.mytest;


import com.alan2lin.bbs.domain.mytest.Mytest;
import com.alan2lin.bbs.domain.mytest.gateway.MytestGateway;
import com.alan2lin.bbs.dto.MytestAddCmd;
import com.alan2lin.bbs.dto.data.ErrorCode;
import com.alan2lin.bbs.dto.data.MytestDTO;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.BizException;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


/**
 * 直接调用 基础层的存储
 */
@Component
public class MytestAddCmdExe {

    @Resource
    MytestGateway mytestGateway;

    public Response execute(MytestAddCmd cmd) {

        MytestDTO mytestDTO = cmd.getMytestDTO();
        Mytest mytest = new Mytest();
        BeanUtils.copyProperties(mytestDTO,mytest);
        mytestGateway.save(mytest);

        return Response.buildSuccess();
    }

}
