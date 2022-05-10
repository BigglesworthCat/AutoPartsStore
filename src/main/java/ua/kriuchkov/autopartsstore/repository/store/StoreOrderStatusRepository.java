package ua.kriuchkov.autopartsstore.repository.store;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.store.StoreOrderStatus;

public interface StoreOrderStatusRepository extends JpaRepository<StoreOrderStatus, Integer> {
}
