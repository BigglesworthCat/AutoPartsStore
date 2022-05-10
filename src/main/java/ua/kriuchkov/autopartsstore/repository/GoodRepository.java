package ua.kriuchkov.autopartsstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.Good;

public interface GoodRepository extends JpaRepository<Good, Integer> {
}
