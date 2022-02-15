package com.client;

import com.model.RatesData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "rate", url = "${openexchangerates.url}")
public interface FeignRatesClient extends RatesClient {

    @GetMapping("/latest.json")
    RatesData getLatestRate(
            @RequestParam("app_id") String app_id
    );

    @GetMapping("/historical/{date}.json")
    RatesData getHistoricalRate(
            @PathVariable String date,
            @RequestParam("app_id") String app_id
    );
}
