package com.alan2lin.bbs.customer;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alan2lin.bbs.api.CustomerServiceI;
import com.alan2lin.bbs.dto.CustomerAddCmd;
import com.alan2lin.bbs.dto.CustomerListByNameQry;
import com.alan2lin.bbs.dto.data.CustomerDTO;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan2lin.bbs.customer.executor.CustomerAddCmdExe;
import com.alan2lin.bbs.customer.executor.query.CustomerListByNameQryExe;




@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}