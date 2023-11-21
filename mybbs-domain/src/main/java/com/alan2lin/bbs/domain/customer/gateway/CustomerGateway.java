package com.alan2lin.bbs.domain.customer.gateway;

import com.alan2lin.bbs.domain.customer.Customer;

public interface CustomerGateway {
    Customer getByById(String customerId);
}
