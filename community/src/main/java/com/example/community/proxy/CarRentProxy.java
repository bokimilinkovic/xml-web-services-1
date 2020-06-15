package com.example.community.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@FeignClient(name = "rent")
public interface CarRentProxy {


    @PostMapping(value = "/api/booking/checking")
    ResponseEntity<Boolean> checkingBookingRequests(@RequestBody String jsonObject, @RequestHeader("Authorization") String auth);

    @GetMapping(value = "/api/booking/{id}/ad", produces = "application/json")
    ResponseEntity<Long> getBookingsAd(@PathVariable("id") Long id, @RequestHeader("Authorization") String auth);

    }