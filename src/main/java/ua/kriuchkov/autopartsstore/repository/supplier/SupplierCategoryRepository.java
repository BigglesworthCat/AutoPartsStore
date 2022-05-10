package ua.kriuchkov.autopartsstore.repository.supplier;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.supplier.SupplierCategory;

public interface SupplierCategoryRepository extends JpaRepository<SupplierCategory, Integer> {
}
