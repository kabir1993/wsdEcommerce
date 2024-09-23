package com.example.controller;

import com.example.service.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/total-sale")
    public double getTotalSalesToday() {
        return saleService.getTotalSalesForToday();
    }
    @GetMapping("/max-sale")
    public Optional<LocalDate> getMaxSaleDay(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return saleService.getMaxSaleDay(startDate, endDate);
    }
}
