package com.service;

import com.client.FeignGifClient;
import com.service.interfaces.gifService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class gifServiceImpl implements gifService {
    private final FeignGifClient gifClient;

    @Value("${giphy.api.key}")
    private String apiKey;
    String limit = "1";
    Integer offset = 0;

    @Override
    public Object getGif(String tag) {
        log.info("inside gif service Impl");
        offset = ++offset;
        return gifClient.getGif(tag, this.apiKey, limit, offset.toString());
    }
}
