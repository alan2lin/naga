package com.alan2lin.bbs.customer;

import com.alan2lin.bbs.customer.executor.query.CustomerListByIdQryExe;
import com.alan2lin.bbs.dto.CustomerListByIdQry;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alan2lin.bbs.api.CustomerServiceI;
import com.alan2lin.bbs.dto.CustomerAddCmd;
import com.alan2lin.bbs.dto.CustomerListByNameQry;
import com.alan2lin.bbs.dto.data.CustomerDTO;
import com.alibaba.cola.dto.SingleResponse;
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

    @Resource
    private CustomerListByIdQryExe customerListByIdQryExe;


    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

    @Override
    public SingleResponse<CustomerDTO> listById(CustomerListByIdQry customerListByIdQry) {
        return customerListByIdQryExe.execute(customerListByIdQry);
    }

}