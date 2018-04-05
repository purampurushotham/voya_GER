package com.voyager.service;

import com.voyager.dao.AdressDAO;
import com.voyager.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AdressDAO adressDAO;

    @Override
    @Transactional
    public List<Address> getAllAddress() {
        return adressDAO.getAllAddress();
    }

    @Override
    @Transactional
    public void addAddress(Address address) {
        adressDAO.addAddress(address);
    }

    @Override
    @Transactional
    public Address getAddress(Integer addressId) {
        return  adressDAO.getAddress(addressId);
    }

    @Override
    @Transactional
    public void deleteAddress(Integer addressId) {
        adressDAO.deleteAddress(addressId);
    }

    @Override
    @Transactional
    public Address updateAddress(Address address) {
        return adressDAO.updateAddress(address);
    }
}
