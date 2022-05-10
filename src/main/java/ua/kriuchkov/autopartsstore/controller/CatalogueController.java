package ua.kriuchkov.autopartsstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kriuchkov.autopartsstore.model.Catalogue;
import ua.kriuchkov.autopartsstore.service.CatalogueService;

import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {
    public final CatalogueService catalogueService;

    @Autowired
    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping("/catalogue_menu")
    public String catalogueMenu(Model model) {
        return "catalogue/catalogue_menu";
    }

    @GetMapping("/catalogue_list")
    public String catalogueList(Model model) {
        List<Catalogue> catalogues = catalogueService.findAll();
        model.addAttribute("catalogues", catalogues);
        return "catalogue/catalogue_list";
    }
}
