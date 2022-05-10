package ua.kriuchkov.autopartsstore.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kriuchkov.autopartsstore.model.customer.CustomerOrder;
import ua.kriuchkov.autopartsstore.repository.customer.CustomerOrderRepository;

import java.util.List;

@Service
public class CustomerOrderService {
    public final CustomerOrderRepository customerOrderRepository;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    public CustomerOrder findById(Integer id) {
        return customerOrderRepository.findById(id).orElse(null);
    }

    public List<CustomerOrder> findAll() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder saveCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    public void deleteById(Integer id) {
        customerOrderRepository.deleteById(id);
    }
}
