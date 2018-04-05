package com.voyager.dao;

import com.voyager.model.Address;

import java.util.List;

public interface AdressDAO {
    public void addAddress(Address address);
    public List<Address> getAllAddress();
    public void deleteAddress(Integer Id);
    public Address updateAddress(Address address);
    public Address getAddress(Integer Id);
}
