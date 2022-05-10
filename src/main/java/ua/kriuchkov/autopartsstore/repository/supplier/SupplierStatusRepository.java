package ua.kriuchkov.autopartsstore.repository.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.supplier.SupplierStatus;

public interface SupplierStatusRepository extends JpaRepository<SupplierStatus, Integer> {
}
