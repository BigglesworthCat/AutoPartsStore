package ua.kriuchkov.autopartsstore.model.storage;

import lombok.Data;
import ua.kriuchkov.autopartsstore.model.Catalogue;
import ua.kriuchkov.autopartsstore.model.store.StoreOrderStatus;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "storage")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cell_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sku_id")
    private Catalogue catalogue;

    @Column(name = "sku_amount")
    private Integer skuAmount;

    @Column(name = "cell_capacity")
    private Integer capacity;

    @Column(name = "replenishment_date")
    private Date replenishmentDate;
}
