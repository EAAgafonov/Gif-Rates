package com.service;

import com.client.FeignRatesClient;
import com.model.RatesData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class rateServiceImplTest {
    @Mock
    private FeignRatesClient feignRatesClient;

    private rateServiceImpl underTest;

    private final RatesData latestRate = mock(RatesData.class);
    private final RatesData historicalRate = mock(RatesData.class);

    @Value("${openexchangerates.app.id}")
    private String app_id;

    @BeforeEach
    void setUp() {
        underTest = new rateServiceImpl(feignRatesClient);

        Map<String, Double> mapL = new HashMap<>();
        Map<String, Double> mapH = new HashMap<>();
        mapL.put("TEST", 1.0002);
        mapH.put("TEST", 2.0);
        latestRate.setRates(mapL);
        historicalRate.setRates(mapH);
    }

    @Test
    void getLatestRateTest() {
        underTest.getLatestRate();
        verify(feignRatesClient).getLatestRate(app_id);
    }

    @Test
    void getHistoricalRateTest() {
        underTest.getHistoricalRate();
        String date = LocalDate.now().minusDays(1L).toString();
        verify(feignRatesClient).getHistoricalRate(date, app_id);

    }


}