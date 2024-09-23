package com.example.repository;

import com.example.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    double sumBySaleDate(LocalDate date);

    @Query("SELECT s.saleDate, SUM(s.amount) AS total FROM Sale s WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY s.saleDate ORDER BY total DESC")
    Optional<LocalDate> findMaxSaleDayBetween(LocalDate startDate, LocalDate endDate);
    @Query("SELECT s.product, COUNT(s.id) AS salesCount FROM Sale s WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY s.product ORDER BY salesCount DESC")
    List<Object[]> findTop5SellingItemsLastMonth(LocalDate startDate, LocalDate endDate);
}
