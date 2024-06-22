package com.example.demo.controller;

import com.example.demo.model.AdData;
import com.example.demo.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@Validated
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping("/api/ads")
    public ResponseEntity<List<AdData>> getAdData(
            @RequestParam(required = false, defaultValue = "date") String sortBy,
            @RequestParam(required = false, defaultValue = "asc") String order) {
        return ResponseEntity.ok(adService.getAllAds(sortBy, order));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body("Validation error: " + e.getMessage());
    }
}
