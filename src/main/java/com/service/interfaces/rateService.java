package com.service.interfaces;

import com.model.RatesData;

import java.util.List;

public interface rateService {
    Boolean isGrown(String code);

    RatesData getLatestRate();

    RatesData getHistoricalRate();

    List<String> getCodes();
}
