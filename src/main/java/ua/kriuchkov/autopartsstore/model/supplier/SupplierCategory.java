package ua.kriuchkov.autopartsstore.model.supplier;

import lombok.Data;
import ua.kriuchkov.autopartsstore.model.supplier.Supplier;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "suppliers_categories")
public class SupplierCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_category_id")
    private Integer id;

    @Column(name = "supplier_category_name")
    private String name;

    @OneToMany(mappedBy = "category_id")
    Set<Supplier> suppliers;
}
