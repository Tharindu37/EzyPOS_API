package com.bootcamp.pos.EzyPOS.service;

import com.bootcamp.pos.EzyPOS.dto.request.CustomerRequestDto;
import com.bootcamp.pos.EzyPOS.dto.response.CustomerResponseDto;
import com.bootcamp.pos.EzyPOS.dto.response.paginate.PaginatedCustomerResponseDto;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerRequestDto dto);
    public CustomerResponseDto findCustomer(String id) throws ClassNotFoundException;
    public String updateCustomer(CustomerRequestDto dto, String id) throws ClassNotFoundException;
    public String deleteCustomer(String id);
    public PaginatedCustomerResponseDto findAllCustomer(String searchText,int page, int size);
}
