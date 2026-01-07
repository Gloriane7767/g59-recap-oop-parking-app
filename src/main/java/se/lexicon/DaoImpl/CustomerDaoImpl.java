package se.lexicon.DaoImpl;

import se.lexicon.dao.CustomerDao;
import se.lexicon.model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public class CustomerDaoImpl implements CustomerDao {
    private List<Customer> customers = new ArrayList<>();
    @Override
    public Customer persist(Customer customer) {
        customers.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public Collection<Customer> findAll() {
        return new ArrayList<>(customers);
    }

    @Override
    public void remove(Integer id) {
        customers.removeIf(customer -> customer.getId().equals(id));
    }
}
