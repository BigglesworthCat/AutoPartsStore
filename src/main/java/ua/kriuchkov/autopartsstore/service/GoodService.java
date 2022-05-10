package ua.kriuchkov.autopartsstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kriuchkov.autopartsstore.model.Good;
import ua.kriuchkov.autopartsstore.model.store.StoreOrder;
import ua.kriuchkov.autopartsstore.repository.GoodRepository;
import ua.kriuchkov.autopartsstore.repository.store.StoreOrderRepository;

import java.util.List;

@Service
public class GoodService {
    public final GoodRepository goodRepository;

    @Autowired
    public GoodService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    public Good findById(Integer id) {
        return goodRepository.findById(id).orElse(null);
    }

    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    public Good saveGood(Good good) {
        return goodRepository.save(good);
    }

    public void deleteById(Integer id) {
        goodRepository.deleteById(id);
    }
}
