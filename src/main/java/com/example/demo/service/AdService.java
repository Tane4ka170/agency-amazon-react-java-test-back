package com.example.demo.service;

import com.example.demo.model.AdData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdService {

    private List<AdData> ads = new ArrayList<>();

    public AdService() {
        // Mock data
        ads.add(new AdData("2024-06-01", 150));
        ads.add(new AdData("2024-06-02", 200));
        ads.add(new AdData("2024-06-03", 250));
        ads.add(new AdData("2024-06-04", 100));
        ads.add(new AdData("2024-06-05", 300));
        ads.add(new AdData("2024-06-06", 175));
        ads.add(new AdData("2024-06-07", 225));
        ads.add(new AdData("2024-06-08", 275));
        ads.add(new AdData("2024-06-09", 125));
        ads.add(new AdData("2024-06-10", 325));
        // Add more data if necessary
    }

    public List<AdData> getAllAds(String sortBy, String order) {
        Comparator<AdData> comparator;

        switch (sortBy) {
            case "value":
                comparator = Comparator.comparing(AdData::getValue);
                break;
            case "date":
            default:
                comparator = Comparator.comparing(AdData::getDate);
                break;
        }

        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        return ads.stream().sorted(comparator).collect(Collectors.toList());
    }
}
