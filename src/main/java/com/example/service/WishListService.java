/**
 * Created by Puraby Deb
 * Date :9/22/2024
 * Time :12:54 PM
 * Project Name : demo
 */

package com.example.service;

import com.example.model.WishList;
import com.example.repository.WishListRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishListService {

    private final WishListRepository wishListRepository;

    public WishListService(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }

    public Optional<WishList> getWishListByCustomerName(String customerName){
        return wishListRepository.findByCustomerName(customerName);
    }
}
