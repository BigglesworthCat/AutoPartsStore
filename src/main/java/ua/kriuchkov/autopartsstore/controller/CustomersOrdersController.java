package ua.kriuchkov.autopartsstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kriuchkov.autopartsstore.model.Catalogue;
import ua.kriuchkov.autopartsstore.model.customer.CustomerOrder;
import ua.kriuchkov.autopartsstore.repository.customer.CustomerOrderRepository;
import ua.kriuchkov.autopartsstore.service.CatalogueService;
import ua.kriuchkov.autopartsstore.service.customer.CustomerOrderService;

import java.util.List;

@Controller
@RequestMapping("/customers_orders")
public class CustomersOrdersController {
    public final CustomerOrderService customerOrderService;

    @Autowired
    public CustomersOrdersController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @GetMapping("/customers_orders_menu")
    public String customersOrdersMenu(Model model) {
        return "customers_orders/customers_orders_menu";
    }

    @GetMapping("/customers_orders_list")
    public String customersOrdersList(Model model) {
        List<CustomerOrder> customerOrders = customerOrderService.findAll();
        model.addAttribute("customerOrders", customerOrders);
        return "customers_orders/customers_orders_list";
    }
}
