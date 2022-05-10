package ua.kriuchkov.autopartsstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kriuchkov.autopartsstore.model.storage.Storage;
import ua.kriuchkov.autopartsstore.service.storage.StorageService;

import java.util.List;

@Controller
@RequestMapping("/storage")
public class StorageController {
    public final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String menu(Model model) {
        return "storage/storage_menu";
    }

    @GetMapping("/storage_list")
    public String findAll(Model model) {
        List<Storage> storages = storageService.findAll();
        model.addAttribute("storages", storages);
        return "storage/storage_list";
    }
}
