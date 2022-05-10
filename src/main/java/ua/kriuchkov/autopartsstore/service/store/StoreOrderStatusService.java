package ua.kriuchkov.autopartsstore.service.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kriuchkov.autopartsstore.model.store.StoreOrder;
import ua.kriuchkov.autopartsstore.model.store.StoreOrderStatus;
import ua.kriuchkov.autopartsstore.repository.store.StoreOrderRepository;
import ua.kriuchkov.autopartsstore.repository.store.StoreOrderStatusRepository;

import java.util.List;

@Service
public class StoreOrderStatusService {
    public final StoreOrderStatusRepository storeOrderStatusRepository;

    @Autowired
    public StoreOrderStatusService(StoreOrderStatusRepository storeOrderStatusRepository) {
        this.storeOrderStatusRepository = storeOrderStatusRepository;
    }

    public StoreOrderStatus findById(Integer id) {
        return storeOrderStatusRepository.findById(id).orElse(null);
    }

    public List<StoreOrderStatus> findAll() {
        return storeOrderStatusRepository.findAll();
    }

    public StoreOrderStatus saveStoreOrderStatus(StoreOrderStatus storeOrderStatus) {
        return storeOrderStatusRepository.save(storeOrderStatus);
    }

    public void deleteById(Integer id) {
        storeOrderStatusRepository.deleteById(id);
    }
}
