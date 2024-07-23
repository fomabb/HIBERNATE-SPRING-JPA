package org.iase24.com.repository;

import org.iase24.com.entity.Address;

import java.util.List;

public interface AddressRepository {

    void add(Address address);

    List<Address> getAll();

    Address getById(Long id);

    void update(Address address);

    void remove(Address address);
}
