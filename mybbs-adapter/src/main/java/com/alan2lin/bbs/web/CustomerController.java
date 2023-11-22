package com.alan2lin.bbs.web;

import com.alan2lin.bbs.dto.CustomerListByIdQry;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alan2lin.bbs.api.CustomerServiceI;
import com.alan2lin.bbs.dto.CustomerAddCmd;
import com.alan2lin.bbs.dto.CustomerListByNameQry;
import com.alan2lin.bbs.dto.data.CustomerDTO;
import com.alibaba.cola.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;

    @GetMapping(value = "/helloworld")
    public String helloWorld(){
        return "Hello, welcome to COLA world!";
    }

    @GetMapping(value = "/customer")
    public MultiResponse<CustomerDTO> listCustomerByName(@RequestParam(required = false) String name){
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setName(name);
        return customerService.listByName(customerListByNameQry);
    }
    @GetMapping(value = "/customer2")
    public SingleResponse<CustomerDTO> listCustomerById(@RequestParam(required = false) String id){
        CustomerListByIdQry customerListByIdQry = new CustomerListByIdQry();
        customerListByIdQry.setId(id);
        return customerService.listById(customerListByIdQry);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd){
        return customerService.addCustomer(customerAddCmd);
    }
}
