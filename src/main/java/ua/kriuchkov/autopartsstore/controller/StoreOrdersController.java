package ua.kriuchkov.autopartsstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kriuchkov.autopartsstore.model.storage.Storage;
import ua.kriuchkov.autopartsstore.model.store.StoreOrder;
import ua.kriuchkov.autopartsstore.repository.store.StoreOrderRepository;
import ua.kriuchkov.autopartsstore.service.CatalogueService;
import ua.kriuchkov.autopartsstore.service.store.StoreOrderService;

import java.util.List;

@Controller
@RequestMapping("/store_orders")
public class StoreOrdersController {
    public final StoreOrderService storeOrderService;

    @Autowired
    public StoreOrdersController(StoreOrderService storeOrderService) {
        this.storeOrderService = storeOrderService;
    }

    @GetMapping("/")
    public String menu(Model model) {
        return "store_orders/store_orders_menu";
    }

    @GetMapping("/storage_list")
    public String findAll(Model model) {
        List<StoreOrder> storeOrders = storeOrderService.findAll();
        model.addAttribute("storeOrders", storeOrders);
        return "storage/storage_list";
    }
}
