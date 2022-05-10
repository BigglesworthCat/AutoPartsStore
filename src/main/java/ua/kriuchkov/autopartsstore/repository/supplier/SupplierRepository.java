package ua.kriuchkov.autopartsstore.repository.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.supplier.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
