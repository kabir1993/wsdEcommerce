package com.example.controller;

import com.example.model.WishList;
import com.example.service.WishListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    private final WishListService wishListService;

    public WishListController(WishListService wishListService) {
        this.wishListService = wishListService;
    }

    @GetMapping("/{customerName}")
    public Optional<WishList> getWishList(@PathVariable String customerName){
        return wishListService.getWishListByCustomerName(customerName);
    }
}
