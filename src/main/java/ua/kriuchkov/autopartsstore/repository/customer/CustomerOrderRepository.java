package ua.kriuchkov.autopartsstore.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.customer.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
}
