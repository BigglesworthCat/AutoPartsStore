package ua.kriuchkov.autopartsstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.kriuchkov.autopartsstore.repository.StatisticsRepository;

import java.sql.Date;
import java.util.Arrays;

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
    public String suppliersByGood() {
        System.out.println("<------=== Task 1 ===------>");
        System.out.println("<~~~ Part 1 ~~~>");
        var res = statisticsRepository.suppliersByGood("Аккумулятор", "Дилер");
        int count = res.size();
        System.out.println("Count: " + count);
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/1.2")
    public String suppliersByGoodAndAmountInPeriod() {
        System.out.println("<------=== Task 1 ===------>");
        System.out.println("<~~~ Part 2 ~~~>");
        var res = statisticsRepository.suppliersByGoodAndAmountInPeriod("Аккумулятор", "Дилер", 3, Date.valueOf("2022-01-01"), Date.valueOf("2022-05-12"));
        var count = res.size();
        System.out.println("Count: " + count);
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/2")
    public String goodInfo() {
        System.out.println("<------=== Task 2 ===------>");
        var res = statisticsRepository.goodInfo("Аккумулятор");
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/3.1")
    public String goodSalesByAmount() {
        System.out.println("<------=== Task 3 ===------>");
        System.out.println("<~~~ Part 1 ~~~>");
        var res = statisticsRepository.goodSalesByAmount("Аккумулятор", 3);
        int count = res.size();
        System.out.println("Count: " + count);
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/3.2")
    public String goodSalesInPeriod() {
        System.out.println("<------=== Task 3 ===------>");
        System.out.println("<~~~ Part 2 ~~~>");
        var res = statisticsRepository.goodSalesInPeriod("Аккумулятор", Date.valueOf("2022-01-01"), Date.valueOf("2022-05-12"));
        int count = res.size();
        System.out.println("Count: " + count);
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/4")
    public String storageInfo() {
        System.out.println("<------=== Task 4 ===------>");
        var res = statisticsRepository.storageInfo();
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/5.1")
    public String tenBestSoldGoods() {
        System.out.println("<------=== Task 5 ===------>");
        System.out.println("<~~~ Part 1 ~~~>");
        var res = statisticsRepository.tenBestSoldGoods();
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/5.2")
    public String tenCheapestSuppliersByGood() {
        System.out.println("<------=== Task 5 ===------>");
        System.out.println("<~~~ Part 2 ~~~>");
        var res = statisticsRepository.tenCheapestSuppliersByGood("Аккумулятор");
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/6")
    public String goodAverageSalesByMonths() {
        System.out.println("<------=== Task 6 ===------>");
        var res = statisticsRepository.goodAverageSalesByMonths();
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/7")
    public String supplierPartInPeriod() {
        System.out.println("<------=== Task 7 ===------>");
        var res = statisticsRepository.supplierPartInPeriod("Мустанг", Date.valueOf("2022-01-01"), Date.valueOf("2022-05-12"));
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/8")
    public String overheadsPart() {
        System.out.println("<------=== Task 8 ===------>");
        var res = statisticsRepository.overheadsPart();
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/9")
    public String unsoldGoods() {
        System.out.println("<------=== Task 9 ===------>");
        var res = statisticsRepository.unsoldGoods();
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/10")
    public String suppliersByDefectedSKUs() {
        System.out.println("<------=== Task 10 ===------>");
        var suppliers = statisticsRepository.suppliersByDefectedSKUs();
        suppliers.forEach(x -> System.out.println(Arrays.toString(x)));

        var totalDefectedSKUs = statisticsRepository.totalDefectedSKUs();
        totalDefectedSKUs.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/11")
    public String sellsInDay() {
        System.out.println("<------=== Task 11 ===------>");
        var sells = statisticsRepository.sellsInDay(Date.valueOf("2022-05-09"));
        sells.forEach(x -> System.out.println(Arrays.toString(x)));

        var totalSells = statisticsRepository.totalSellsInDay(Date.valueOf("2022-05-09"));
        totalSells.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/12.1")
    public String cashReportInDay() {
        System.out.println("<------=== Task 12 ===------>");
        System.out.println("<~~~ Part 1 ~~~>");
        var cashReport = statisticsRepository.cashReportInDay(Date.valueOf("2022-05-09"));
        cashReport.forEach(x -> System.out.println(Arrays.toString(x)));

        var totalCahReport = statisticsRepository.totalCashReportInDay(Date.valueOf("2022-05-09"));
        totalCahReport.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/12.2")
    public String cashReportInPeriod() {
        System.out.println("<------=== Task 12 ===------>");
        System.out.println("<~~~ Part 2 ~~~>");
        var cashReport = statisticsRepository.cashReportInPeriod(Date.valueOf("2022-01-01"), Date.valueOf("2022-05-14"));
        cashReport.forEach(x -> System.out.println(Arrays.toString(x)));

        var totalCashReport = statisticsRepository.totalCashReportInPeriod(Date.valueOf("2022-01-01"), Date.valueOf("2022-05-14"));
        totalCashReport.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/13")
    public String inventoryReport() {
        System.out.println("<------=== Task 13 ===------>");
        var res = statisticsRepository.inventoryReport();
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/14")
    public String velocityOfGood() {
        System.out.println("<------=== Task 14 ===------>");
        var res = statisticsRepository.velocityOfGood("Аккумулятор", Date.valueOf("2022-02-01"), Date.valueOf("2022-06-01"));
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/15")
    public String storageFreeSpace() {
        System.out.println("<------=== Task 15 ===------>");
        var res = statisticsRepository.storageFreeSpace();
        res.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }

    @GetMapping("/16")
    public String customersBookings() {
        System.out.println("<------=== Task 16 ===------>");
        var customersBookings = statisticsRepository.customersBookings();
        customersBookings.forEach(x -> System.out.println(Arrays.toString(x)));

        var totalCustomersBookings = statisticsRepository.totalCustomersBookings();
        totalCustomersBookings.forEach(x -> System.out.println(Arrays.toString(x)));
        return "statistics/statistics_menu";
    }
}
