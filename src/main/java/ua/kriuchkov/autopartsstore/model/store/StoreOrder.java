package ua.kriuchkov.autopartsstore.model.store;

import lombok.Data;
import ua.kriuchkov.autopartsstore.model.Catalogue;
import ua.kriuchkov.autopartsstore.model.customer.CustomerOrderStatus;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "store_orders")
public class StoreOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_order_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sku_id")
    private Catalogue catalogue;

    @Column(name = "sku_amount")
    private Integer skuAmount;

    @ManyToOne
    @JoinColumn(name = "store_order_status_id")
    private StoreOrderStatus storeOrderStatus;

    @Column(name = "store_order_date")
    private Date date;
}
