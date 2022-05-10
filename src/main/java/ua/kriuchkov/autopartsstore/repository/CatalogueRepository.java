package ua.kriuchkov.autopartsstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kriuchkov.autopartsstore.model.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
}
