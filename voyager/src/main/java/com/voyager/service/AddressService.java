package com.voyager.service;

import com.voyager.model.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAllAddress();
    public void addAddress(Address address);
    public Address getAddress(Integer addressId);
    public void deleteAddress(Integer addressId);
    public Address updateAddress(Address address);
}
