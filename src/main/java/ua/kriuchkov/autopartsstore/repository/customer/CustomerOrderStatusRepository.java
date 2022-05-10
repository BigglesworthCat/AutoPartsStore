package ua.kriuchkov.autopartsstore.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.customer.CustomerOrderStatus;

public interface CustomerOrderStatusRepository extends JpaRepository<CustomerOrderStatus, Integer> {
}
