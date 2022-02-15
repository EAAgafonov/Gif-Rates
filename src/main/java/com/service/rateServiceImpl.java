package com.service;

import com.client.RatesClient;
import com.model.RatesData;
import com.service.interfaces.rateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class rateServiceImpl implements rateService {
    private final RatesClient ratesClient;

    @Value("${openexchangerates.app.id}")
    private String app_id;

    @Override
    public Boolean isGrown(String code) {
        RatesData latestRate = getLatestRate();
        RatesData yesterdayRate = getHistoricalRate();

        double coefficientToday = (latestRate.getRates().get(code)) / (latestRate.getRates().get("RUB"));
        double coefficientBefore = (yesterdayRate.getRates().get(code)) / (yesterdayRate.getRates().get("RUB"));

        return coefficientToday > coefficientBefore;
    }

    @Override
    public RatesData getLatestRate() {
        log.info("Inside getLatestRate");
        return ratesClient.getLatestRate(app_id);
    }

    @Override
    public RatesData getHistoricalRate() {
        log.info("Inside getHistoricalRate");
        String date = LocalDate.now().minusDays(1L).toString();
        return ratesClient.getHistoricalRate(date, app_id);
    }

    @Override
    public List<String> getCodes() {
        return new ArrayList<>(ratesClient.getLatestRate(app_id).getRates().keySet());
    }
}
