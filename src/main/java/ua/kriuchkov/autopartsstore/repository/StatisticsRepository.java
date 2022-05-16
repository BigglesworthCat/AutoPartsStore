package ua.kriuchkov.autopartsstore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StatisticsRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StatisticsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Task 1
    public List<Object[]> suppliersByGood(String good, String supplierCategory) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL suppliers_by_good(?, ?);", good, supplierCategory)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> suppliersByGoodAndAmountInPeriod(String good, String supplierCategory, Integer amount, Date sinceDate, Date untilDate) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL suppliers_by_good_in_period(?, ?, ?, ?, ?);", good, supplierCategory, amount, sinceDate, untilDate)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 2
    public List<Object[]> goodInfo(String good) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL good_info(?);", good)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 3
    public List<Object[]> goodSalesByAmount(String good, Integer amount) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL sales_by_amount(?, ?);", good, amount)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> goodSalesInPeriod(String good, Date sinceDate, Date untilDate) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL sales_in_period(?, ?, ?);", good, sinceDate, untilDate)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 4
    public List<Object[]> storageInfo() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL storage_info();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 5
    public List<Object[]> tenBestSoldGoods() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL ten_best_sold_goods();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> tenCheapestSuppliersByGood(String good) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL ten_cheapest_suppliers_by_good(?);", good)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 6
    public List<Object[]> goodAverageSalesByMonths() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL good_average_sales_by_months();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 7
    public List<Object[]> supplierPartInPeriod(String supplier, Date sinceDate, Date untilDate) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL suppliers_part(?, ?, ?);", supplier, sinceDate, untilDate)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 8
    public List<Object[]> overheadsPart() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL overheads_part();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 9
    public List<Object[]> unsoldGoods() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL unsold_goods();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 10
    public List<Object[]> suppliersByDefectedSKUs() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL suppliers_by_defected_sku();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> totalDefectedSKUs() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL total_defected_sku();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 11
    public List<Object[]> sellsInDay(Date day) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL sells_in_day(?);", day)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> totalSellsInDay(Date day) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL total_sells_in_day(?);", day)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 12
    public List<Object[]> cashReportInDay(Date day) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL cash_report_in_date(?);", day)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> totalCashReportInDay(Date day) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL total_cash_report_in_date(?);", day)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> cashReportInPeriod(Date sinceDate, Date untilDate) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL cash_report_in_period(?, ?);", sinceDate, untilDate)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> totalCashReportInPeriod(Date sinceDate, Date untilDate) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL total_cash_report_in_period(?, ?);", sinceDate, untilDate)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 13
    public List<Object[]> inventoryReport() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL inventory_report();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 14
    public List<Object[]> velocityOfGood(String good, Date sinceDate, Date untilDate) {
        List<Object[]> result = jdbcTemplate.queryForList("CALL velocity_of_good(?, ?, ?);", good, sinceDate, untilDate)
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 15
    public List<Object[]> storageFreeSpace() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL storage_free_space();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    // Task 16
    public List<Object[]> customersBookings() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL customers_bookings();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }

    public List<Object[]> totalCustomersBookings() {
        List<Object[]> result = jdbcTemplate.queryForList("CALL total_customers_bookings();")
                .stream()
                .map(row -> row.values().toArray())
                .collect(Collectors.toList());
        return result;
    }
}