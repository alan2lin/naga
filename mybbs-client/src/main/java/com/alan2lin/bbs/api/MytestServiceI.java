package com.alan2lin.bbs.api;

import com.alan2lin.bbs.dto.*;
import com.alan2lin.bbs.dto.data.MytestDTO;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;

/**
 * client是整个领域服务对外暴露的接口。还负责业务数据转换
 */
public interface MytestServiceI {

    Response addMytestDirectly(MytestAddCmd mytestAddCmd);

    Response addMytestDomain(MytestAddCmd mytestAddCmd);

    SingleResponse<MytestDTO> queryByNameDomain(MytestByNameQry mytestByNameQry);

    SingleResponse<MytestDTO> queryByNameDirectly(MytestByNameQry mytestByNameQry);
}
