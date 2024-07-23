package org.iase24.com.service;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.iase24.com.entity.Address;
import org.iase24.com.repository.AddressRepository;
import org.iase24.com.util.SessionUtil;

import java.util.List;

public class AddressServiceImpl extends SessionUtil implements AddressRepository {

    public void add(Address address) {
        openTransactionSession();

        Session session = getSession();
        session.save(address);
        closeTransactionSession();
    }

    public List<Address> getAll() {
        openTransactionSession();

        Session session = getSession();
        String sql = "SELECT * FROM address";
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addresses = query.list();
        closeTransactionSession();

        return addresses;
    }

    public Address getById(Long id) {
        openTransactionSession();

        Session session = getSession();
        String sql = "SELECT * FROM address WHERE id=:id";
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);
        Address address = (Address) query.getSingleResult();
        closeTransactionSession();

        return address;
    }

    public void update(Address address) {
        openTransactionSession();
        Session session = getSession();
        session.update(address);
        closeTransactionSession();
    }

    public void remove(Address address) {
        openTransactionSession();

        Session session = getSession();
        session.remove(address);
        closeTransactionSession();
    }
}
