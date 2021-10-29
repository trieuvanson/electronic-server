package com.app.electronicserver.service;

import com.app.electronicserver.model.Address;
import com.app.electronicserver.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    Address findById(Integer id);
    List<Address> getAddressByUsername(String username);
    Address saveAddress(Address address);
    void removeAddressByIdAndUsername(Integer id, String username);
    Address updateAddress(Address address, Integer id);
}
