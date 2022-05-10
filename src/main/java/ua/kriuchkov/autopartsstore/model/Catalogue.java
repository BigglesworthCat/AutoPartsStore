package ua.kriuchkov.autopartsstore.model;

import lombok.Data;
import ua.kriuchkov.autopartsstore.model.customer.CustomerOrder;
import ua.kriuchkov.autopartsstore.model.storage.Storage;
import ua.kriuchkov.autopartsstore.model.store.StoreOrder;
import ua.kriuchkov.autopartsstore.model.supplier.Supplier;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "catalogue")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sku_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "good_id")
    private Good good;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "supplier_price")
    private Integer supplierPrice;

    @Column(name = "store_price")
    private Integer storePrice;

    @OneToMany(mappedBy = "catalogue")
    private Set<CustomerOrder> customerOrder;

    @OneToMany(mappedBy = "catalogue")
    private Set<StoreOrder> storeOrder;

    @OneToMany(mappedBy = "catalogue")
    private Set<Storage> storage;
}
