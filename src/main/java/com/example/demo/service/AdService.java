package com.example.demo.service;

import com.example.demo.model.AdData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdService {
    private List<AdData> adDataList = new ArrayList<>();

    public AdService() {
        adDataList.add(new AdData("2024-06-01", 100));
        adDataList.add(new AdData("2024-06-02", 200));
        adDataList.add(new AdData("2024-06-03", 150));
    }

    public List<AdData> getAllAds(String sortBy, String order) {
        Comparator<AdData> comparator = Comparator.comparing(AdData::getDate);

        if ("value".equalsIgnoreCase(sortBy)) {
            comparator = Comparator.comparing(AdData::getValue);
        }

        if ("desc".equalsIgnoreCase(order)) {
            comparator = comparator.reversed();
        }

        return adDataList.stream().sorted(comparator).collect(Collectors.toList());
    }
}
