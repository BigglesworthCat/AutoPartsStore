package ua.kriuchkov.autopartsstore.repository.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.storage.Storage;

public interface StorageRepository extends JpaRepository<Storage, Integer> {
}
