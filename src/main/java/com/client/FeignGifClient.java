package com.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "giphy", url = "${giphy.url}")
public interface FeignGifClient extends GifClient {

    @GetMapping()
    Object getGif(
            @RequestParam(name = "q", required = false) String q,
            @RequestParam(name = "api_key", required = false) String api_key,
            @RequestParam(name = "limit", required = false) String limit,
            @RequestParam(name = "offset", required = false) String offset
    );
}
