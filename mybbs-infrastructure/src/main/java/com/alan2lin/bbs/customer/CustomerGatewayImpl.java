package com.alan2lin.bbs.customer;

import com.alan2lin.bbs.domain.customer.Customer;
import com.alan2lin.bbs.domain.customer.gateway.CustomerGateway;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerGatewayImpl implements CustomerGateway {
    @Autowired
    private CustomerMapper customerMapper;

    public Customer getById(String customerId){
      CustomerDO customerDO = customerMapper.getByXXX(customerId);
        //Convert to Customer
      Customer customer = new Customer();
        BeanUtils.copyProperties(customerDO,customer);

      return customer;
    }
}
