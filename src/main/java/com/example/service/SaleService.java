package com.example.service;

import com.example.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }
    public double getTotalSalesForToday() {
        return saleRepository.sumBySaleDate(LocalDate.now());
    }

    public Optional<LocalDate> getMaxSaleDay(LocalDate startDate, LocalDate endDate) {
        return saleRepository.findMaxSaleDayBetween(startDate, endDate);
    }
}
