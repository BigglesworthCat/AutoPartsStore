package ua.kriuchkov.autopartsstore.model.customer;

import lombok.Data;
import ua.kriuchkov.autopartsstore.model.customer.CustomerOrder;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "customers_orders_statuses")
public class CustomerOrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_order_status_id")
    private Integer id;

    @Column(name = "customer_order_status_name")
    private String name;

    @OneToMany(mappedBy = "customer_order_status_id")
    Set<CustomerOrder> customerOrder;
}