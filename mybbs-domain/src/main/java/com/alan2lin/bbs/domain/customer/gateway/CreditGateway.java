package com.alan2lin.bbs.domain.customer.gateway;

import com.alan2lin.bbs.domain.customer.Credit;

//Assume that the credit info is in another distributed Service
public interface CreditGateway {
    Credit getCredit(String customerId);
}
