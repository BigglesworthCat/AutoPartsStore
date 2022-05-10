package ua.kriuchkov.autopartsstore.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.store.StoreOrder;

public interface StoreOrderRepository extends JpaRepository<StoreOrder, Integer> {
}
