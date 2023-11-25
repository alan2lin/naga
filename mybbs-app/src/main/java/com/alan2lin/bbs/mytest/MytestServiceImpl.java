package com.alan2lin.bbs.mytest;

import com.alan2lin.bbs.api.CustomerServiceI;
import com.alan2lin.bbs.api.MytestServiceI;
import com.alan2lin.bbs.customer.executor.CustomerAddCmdExe;
import com.alan2lin.bbs.customer.executor.query.CustomerListByIdQryExe;
import com.alan2lin.bbs.customer.executor.query.CustomerListByNameQryExe;
import com.alan2lin.bbs.domain.mytest.Mytest;
import com.alan2lin.bbs.domain.mytest.MytestDomainService;
import com.alan2lin.bbs.dto.*;
import com.alan2lin.bbs.dto.data.CustomerDTO;
import com.alan2lin.bbs.dto.data.MytestDTO;
import com.alibaba.cola.catchlog.ApplicationContextHelper;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * app层 负责 业务的编排，负责将本领域对象，本领域服务和其他的领域服务或其他的服务整合，形成一个完整的业务输出。
 * 对下可能调用到 domain层服务， 以及infrastructure层。
 * 上下文的映射，是否应该在此层得到实现呢? 待确定
 */

@Service
@CatchAndLog
public class MytestServiceImpl implements MytestServiceI {


    @Resource
    MytestDomainService mytestDomainService;


    @Resource
    MytestAddCmdExe mytestAddCmdExe;

    @Resource
    MytestQryCmdExe mytestQryCmdExe;


    @Override
    public Response addMytestDirectly(MytestAddCmd mytestAddCmd) {

        mytestDomainService.appendMytestByDomainLogic();

        return mytestAddCmdExe.execute(mytestAddCmd);

    }
    @Override
    public Response addMytestDomain(MytestAddCmd mytestAddCmd) {

        mytestDomainService.appendMytestByDomainLogic();
        Mytest mytest = ApplicationContextHelper.getBean(Mytest.class);
        try{
            mytest.doDomainLogicThenSave();

        }catch (Exception e){
            return Response.buildFailure("01","create mytest failed");
        }
        return Response.buildSuccess();

    }

    @Override
    public SingleResponse<MytestDTO> queryByNameDomain(MytestByNameQry mytestByNameQry) {
        //服务编排  直接调用领域service

        mytestDomainService.queryMytestByDomainLogic();

        return  mytestQryCmdExe.execute(mytestByNameQry);

    }

    @Override
    public SingleResponse<MytestDTO> queryByNameDirectly(MytestByNameQry mytestByNameQry) {
        //服务编排 or 直接调用领域service

        return  mytestQryCmdExe.execute(mytestByNameQry);

    }

}