/**
 * Created by Puraby Deb
 * Date :9/22/2024
 * Time :3:53 PM
 * Project Name : demo
 */

package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import com.example.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;

    public ProductService(ProductRepository productRepository, SaleRepository saleRepository) {
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
    }

    public List<Product> getTop5SellingProductsOfAllTime() {
        return productRepository.findTop5ByOrderByTotalSaleDesc();
    }
    public List<Object[]> getTop5SellingItemsLastMonth(LocalDate startDate, LocalDate endDate) {
        return saleRepository.findTop5SellingItemsLastMonth(startDate, endDate);
    }
}
