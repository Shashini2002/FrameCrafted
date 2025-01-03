package edu.icet.demo.service;


import edu.icet.demo.dto.CustomerSupport;

import java.util.List;
public interface CustomerSupportService {
    List<CustomerSupport> getAllCustomerSupport();
    void addCustomerSupport(CustomerSupport customerSupport);

    void updateCustomerSupport(CustomerSupport customerSupport);
}
