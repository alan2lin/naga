package com.alan2lin.bbs.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alan2lin.bbs.dto.CustomerAddCmd;
import com.alan2lin.bbs.dto.CustomerListByNameQry;
import com.alan2lin.bbs.dto.data.CustomerDTO;

public interface CustomerServiceI {

    Response addCustomer(CustomerAddCmd customerAddCmd);

    MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
