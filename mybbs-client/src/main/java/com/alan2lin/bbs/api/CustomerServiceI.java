package com.alan2lin.bbs.api;

import com.alan2lin.bbs.dto.CustomerListByIdQry;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alan2lin.bbs.dto.CustomerAddCmd;
import com.alan2lin.bbs.dto.CustomerListByNameQry;
import com.alan2lin.bbs.dto.data.CustomerDTO;
import com.alibaba.cola.dto.SingleResponse;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
    SingleResponse<CustomerDTO> listById(CustomerListByIdQry customerListByIdQry);
}
