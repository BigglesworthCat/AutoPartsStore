package ua.kriuchkov.autopartsstore.model.customer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.kriuchkov.autopartsstore.model.Catalogue;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "customers_orders")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_order_id")
    private Integer id;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "sku_id")
    private Catalogue catalogue;

    @Column(name = "sku_amount")
    private Integer skuAmount;

    @Column(name = "defected_sku_amount")
    private Integer defectedSkuAmount;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "customer_order_status_id")
    private CustomerOrderStatus customerOrderStatus;

    @Column(name = "customer_order_date")
    private Date date;
}
