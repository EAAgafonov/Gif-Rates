package com.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Data
public class RatesData {
    private Map<String, Double> rates;
}
