package com.app.electronicserver.service.impl;

import com.app.electronicserver.model.Address;
import com.app.electronicserver.repo.AddressRepo;
import com.app.electronicserver.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    @Override
    public Address findById(Integer id) {
        return addressRepo.findById(id).get();
    }

    @Override
    public List<Address> getAddressByUsername(String username) {
        return addressRepo.getAddressByUsername(username);
    }

    @Override
    public Address saveAddress(Address address) {
        address.setCreated_at(new Date());
        address.setUpdate_at(new Date());
        return addressRepo.save(address);
    }

    @Override
    public void removeAddressByIdAndUsername(Integer id, String username) {
        addressRepo.deleteCartByIdAndUsername(id, username);
    }

    @Override
    public Address updateAddress(Address address, Integer id) {
        address.setId(id);
        address.setUpdate_at(new Date());
        if (address.getStatus()) {
            getAddressByUsername(address.getUser().getUsername()).forEach(add -> {
                if (add.getId()!= id) {
                    add.setStatus(false);
                    saveAddress(add);
                }
            });
        }
        return addressRepo.save(address);
    }
}
