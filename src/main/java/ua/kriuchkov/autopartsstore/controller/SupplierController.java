package ua.kriuchkov.autopartsstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kriuchkov.autopartsstore.model.supplier.Supplier;
import ua.kriuchkov.autopartsstore.model.supplier.SupplierCategory;
import ua.kriuchkov.autopartsstore.model.supplier.SupplierStatus;
import ua.kriuchkov.autopartsstore.service.supplier.SupplierCategoryService;
import ua.kriuchkov.autopartsstore.service.supplier.SupplierService;
import ua.kriuchkov.autopartsstore.service.supplier.SupplierStatusService;

import java.util.List;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
    public final SupplierService supplierService;
    public final SupplierCategoryService supplierCategoryService;
    public final SupplierStatusService supplierStatusService;

    @Autowired
    public SupplierController(SupplierService supplierService, SupplierCategoryService supplierCategoryService, SupplierStatusService supplierStatusService) {
        this.supplierService = supplierService;
        this.supplierCategoryService = supplierCategoryService;
        this.supplierStatusService = supplierStatusService;
    }

    @GetMapping("/suppliers_list")
    public String catalogueList(Model model) {
        List<Supplier> suppliers = supplierService.findAll();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers_list";
    }

    @GetMapping("/create_supplier")
    public String createSupplierForm(Model model, Supplier supplier) {
        List<SupplierCategory> supplierCategories = supplierCategoryService.findAll();
        List<SupplierStatus> supplierStatuses = supplierStatusService.findAll();
        model.addAttribute("supplierCategories", supplierCategories);
        model.addAttribute("supplierStatuses", supplierStatuses);
        return "suppliers/create_supplier";
    }

    @PostMapping("/create_supplier")
    public String createSupplier(Supplier supplier) {
        System.out.println(supplier);
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers/suppliers_list";
    }

    @GetMapping("/update_supplier/{id}")
    public String updateSupplierForm(@PathVariable("id") Integer id, Model model) {
        Supplier supplier = supplierService.findById(id);
        List<SupplierCategory> supplierCategories = supplierCategoryService.findAll();
        List<SupplierStatus> supplierStatuses = supplierStatusService.findAll();
        model.addAttribute("supplierCategories", supplierCategories);
        model.addAttribute("supplierStatuses", supplierStatuses);
        model.addAttribute("supplier", supplier);
        return "suppliers/update_supplier";
    }

    @PostMapping("/update_supplier")
    public String updateSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/suppliers/suppliers_list";
    }

    @GetMapping("delete_supplier/{id}")
    public String deleteSupplier(@PathVariable("id") Integer id) {
        supplierService.deleteById(id);
        return "redirect:/suppliers/suppliers_list";
    }
}
