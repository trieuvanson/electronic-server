package com.app.electronicserver.service;

import com.app.electronicserver.model.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    List<Address> getAddress();

    Address saveAddress(Address address);

    Address updateAddress(Address address, Integer id);

    void deleteAddress(Integer id);

    Address findById(Integer id);
}
