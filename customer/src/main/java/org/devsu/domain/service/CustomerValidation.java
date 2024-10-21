package org.devsu.domain.service;

import org.devsu.domain.model.Customer;
import org.devsu.domain.service.constant.Constant;

public class CustomerValidation {

    private boolean isActive(Customer cus){
        return cus.getStatus().equals(Constant.CUSTOMER_STATUS_ACTIVE);
    }

}
