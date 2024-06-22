package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Arrays;

@RestController
public class AdController {

    static class DataPoint {
        public String date;
        public int value;

        public DataPoint(String date, int value) {
            this.date = date;
            this.value = value;
        }
    }

    @GetMapping("/api/ads")
    public List<DataPoint> getAdData() {
        return Arrays.asList(
            new DataPoint("2024-06-01", 100),
            new DataPoint("2024-06-02", 200),
            new DataPoint("2024-06-03", 150)
        );
    }
}
