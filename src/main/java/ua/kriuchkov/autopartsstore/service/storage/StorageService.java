package ua.kriuchkov.autopartsstore.service.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kriuchkov.autopartsstore.model.customer.CustomerOrderStatus;
import ua.kriuchkov.autopartsstore.model.storage.Storage;
import ua.kriuchkov.autopartsstore.repository.customer.CustomerOrderStatusRepository;
import ua.kriuchkov.autopartsstore.repository.storage.StorageRepository;

import java.util.List;

@Service
public class StorageService {
    public final StorageRepository storageRepository;

    @Autowired
    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public Storage findById(Integer id) {
        return storageRepository.findById(id).orElse(null);
    }

    public List<Storage> findAll() {
        return storageRepository.findAll();
    }

    public Storage saveStorage(Storage storage) {
        return storageRepository.save(storage);
    }

    public void deleteById(Integer id) {
        storageRepository.deleteById(id);
    }
}
