package ua.kriuchkov.autopartsstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kriuchkov.autopartsstore.repository.StatisticsRepository;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
    public final StatisticsRepository statisticsRepository;

    @Autowired
    public StatisticsController(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @GetMapping("/statistics_menu")
    public String statisticsMenu() {
        return "statistics/statistics_menu";
    }

    @GetMapping("/1.1")
    public String suppliersByGood(Model model,
                                  @RequestParam(required = false) String good,
                                  @RequestParam(required = false) String supplierCategory) {
        var result = statisticsRepository.suppliersByGood(good, supplierCategory);
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Supplier");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/1.2")
    public String suppliersByGoodAndAmountInPeriod(Model model,
                                                   @RequestParam(required = false) String good,
                                                   @RequestParam(required = false) String supplierCategory,
                                                   @RequestParam(required = false) Integer amount,
                                                   @RequestParam(required = false) String sinceDate,
                                                   @RequestParam(required = false) String untilDate) {
        var result = statisticsRepository.suppliersByGoodAndAmountInPeriod(good, supplierCategory, amount, Date.valueOf(sinceDate), Date.valueOf(untilDate));
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Supplier");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/2")
    public String goodInfo(Model model, @RequestParam(required = false) String good) {
        var result = statisticsRepository.goodInfo(good);
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Good", "Supplier", "Supplier price", "Store price", "Delivery days");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/3.1")
    public String goodSalesByAmount(Model model,
                                    @RequestParam(required = false) String good,
                                    @RequestParam(required = false) Integer amount) {
        var result = statisticsRepository.goodSalesByAmount(good, amount);
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Customer order ID", "Good", "SKU amount", "Order date");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/3.2")
    public String goodSalesInPeriod(Model model,
                                    @RequestParam(required = false) String good,
                                    @RequestParam(required = false) String sinceDate,
                                    @RequestParam(required = false) String untilDate) {
        var result = statisticsRepository.goodSalesInPeriod(good, Date.valueOf(sinceDate), Date.valueOf(untilDate));
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Customer order ID", "Good", "SKU amount", "Order date");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/4")
    public String storageInfo(Model model) {
        var result = statisticsRepository.storageInfo();
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Cell ID", "Good", "Supplier", "Capacity");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/5.1")
    public String tenBestSoldGoods(Model model) {
        var result = statisticsRepository.tenBestSoldGoods();
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Good", "Amount");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/5.2")
    public String tenCheapestSuppliersByGood(Model model,
                                             @RequestParam(required = false) String good) {
        var result = statisticsRepository.tenCheapestSuppliersByGood(good);
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Good", "Amount");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/6")
    public String goodAverageSalesByMonths(Model model) {
        var result = statisticsRepository.goodAverageSalesByMonths();
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Good", "Average sales in month");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/7")
    public String supplierPartInPeriod(Model model,
                                       @RequestParam(required = false) String supplier,
                                       @RequestParam(required = false) String sinceDate,
                                       @RequestParam(required = false) String untilDate) {
        var result = statisticsRepository.supplierPartInPeriod(supplier, Date.valueOf(sinceDate), Date.valueOf(untilDate));
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Good part (%)", "Money part", "Good part (in units)", "Profit part (%)");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/8")
    public String overheadsPart(Model model) {
        var result = statisticsRepository.overheadsPart();
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Overheads relatively sells (%)");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/9")
    public String unsoldGoods(Model model) {
        var result = statisticsRepository.unsoldGoods();
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Unsold goods (%)", "Unsold goods (in units)");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/10")
    public String suppliersByDefectedSKUs(Model model,
                                          @RequestParam(required = false) String sinceDate,
                                          @RequestParam(required = false) String untilDate) {
        var result = statisticsRepository.suppliersByDefectedSKUs(Date.valueOf(sinceDate), Date.valueOf(untilDate));
        var count = statisticsRepository.totalDefectedSKUs(Date.valueOf(sinceDate), Date.valueOf(untilDate)).get(0)[0];

        List<String> attributes = List.of("Good", "Supplier", "Defected units");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/11")
    public String sellsInDay(Model model,
                             @RequestParam(required = false) String day) {
        var result = statisticsRepository.sellsInDay(Date.valueOf(day));
        int count = result.size();
        result = count == 0 ? null : result;
        var totalResult = statisticsRepository.totalSellsInDay(Date.valueOf(day));

        List<String> attributes = List.of("Customer order ID", "Good", "Supplier", "SKU amount", "Defected SKU amount", "Sum");
        List<String> totalAttributes = List.of("Total amount", "Total revenue");
        model.addAttribute("attributes", attributes);
        model.addAttribute("totalAttributes", totalAttributes);
        model.addAttribute("result", result);
        model.addAttribute("totalResult", totalResult);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/12.1")
    public String cashReportInDay(Model model,
                                  @RequestParam(required = false) String day) {
        var result = statisticsRepository.cashReportInDay(Date.valueOf(day));
        int count = result.size();
        result = count == 0 ? null : result;
        var totalResult = statisticsRepository.totalCashReportInDay(Date.valueOf(day));

        List<String> attributes = List.of("Good", "Supplier", "Store purchase", "Customers purchase", "Operation date");
        List<String> totalAttributes = List.of("Total store purchase", "Total customers purchase");
        model.addAttribute("attributes", attributes);
        model.addAttribute("totalAttributes", totalAttributes);
        model.addAttribute("result", result);
        model.addAttribute("totalResult", totalResult);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/12.2")
    public String cashReportInPeriod(Model model,
                                     @RequestParam(required = false) String sinceDate,
                                     @RequestParam(required = false) String untilDate)  {
        var result = statisticsRepository.cashReportInPeriod(Date.valueOf(sinceDate), Date.valueOf(untilDate));
        int count = result.size();
        result = count == 0 ? null : result;
        var totalResult = statisticsRepository.totalCashReportInPeriod(Date.valueOf(sinceDate), Date.valueOf(untilDate));

        List<String> attributes = List.of("Good", "Supplier", "Store purchase", "Customers purchase", "Operation date");
        List<String> totalAttributes = List.of("Total store purchase", "Total customers purchase");
        model.addAttribute("attributes", attributes);
        model.addAttribute("totalAttributes", totalAttributes);
        model.addAttribute("result", result);
        model.addAttribute("totalResult", totalResult);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/13")
    public String inventoryReport(Model model) {
        var result = statisticsRepository.inventoryReport();
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Cell ID", "SKU ID", "Good", "Supplier", "Supplier category", "SKU amount", "Cell capacity", "Replenishment date");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/14")
    public String velocityOfGood(Model model,
                                 @RequestParam(required = false) String good,
                                 @RequestParam(required = false) String sinceDate,
                                 @RequestParam(required = false) String untilDate) {
        var result = statisticsRepository.velocityOfGood(good, Date.valueOf(sinceDate), Date.valueOf(untilDate));
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Velocity");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/15")
    public String storageFreeSpace(Model model) {
        var result = statisticsRepository.storageFreeSpace();
        int count = result.size();
        result = count == 0 ? null : result;

        List<String> attributes = List.of("Total free space");
        model.addAttribute("attributes", attributes);
        model.addAttribute("result", result);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }

    @GetMapping("/16")
    public String customersBookings(Model model) {
        var result = statisticsRepository.customersBookings();
        int count = result.size();
        result = count == 0 ? null : result;
        var totalResult = statisticsRepository.totalCustomersBookings();

        List<String> attributes = List.of("Customer order ID", "Good", "Supplier", "SKU amount", "Booking sum", "Operation date");
        List<String> totalAttributes = List.of("Total bookings amount", "Total bookings sum");
        model.addAttribute("attributes", attributes);
        model.addAttribute("totalAttributes", totalAttributes);
        model.addAttribute("result", result);
        model.addAttribute("totalResult", totalResult);
        model.addAttribute("count", count);
        return "statistics/statistics_table";
    }
}
