package com.client;

import com.model.RatesData;

public interface RatesClient {

    RatesData getLatestRate(String app_id);

    RatesData getHistoricalRate(String app_id, String date);
}
