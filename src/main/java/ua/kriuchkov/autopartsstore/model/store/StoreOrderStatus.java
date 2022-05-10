package ua.kriuchkov.autopartsstore.model.store;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "store_orders_statuses")
public class StoreOrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_order_status_id")
    private Integer id;

    @Column(name = "store_order_status_name")
    private String name;

    @OneToMany(mappedBy = "storeOrderStatus")
    private Set<StoreOrder> storeOrder;
}
