package com.alan2lin.bbs.customer.executor.query;

import com.alan2lin.bbs.domain.customer.Customer;
import com.alan2lin.bbs.domain.customer.gateway.CustomerGateway;
import com.alan2lin.bbs.dto.CustomerListByIdQry;
import com.alan2lin.bbs.dto.CustomerListByNameQry;
import com.alan2lin.bbs.dto.data.CustomerDTO;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CustomerListByIdQryExe {

    @Resource
    CustomerGateway customerGateway;

    public SingleResponse<CustomerDTO> execute(CustomerListByIdQry cmd) {
        Customer customer = customerGateway.getById(cmd.getId());
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDTO);
        return SingleResponse.of(customerDTO);
    }
}
