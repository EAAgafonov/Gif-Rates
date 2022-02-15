package com.controllers;

import com.service.interfaces.gifService;
import com.service.interfaces.rateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gif")
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final gifService gifService;
    private final rateService rateService;

    @Value("${giphy.rich}")
    private String richTag;
    @Value("${giphy.broke}")
    private String brokeTag;
    @Value("${openexchangerates.app.id}")
    private String app_id;

    @GetMapping("/{code}")
    public Object getGif(
            @PathVariable String code
    ) {
        log.info("inside getGif in Controller");
        String tag;

        if (rateService.isGrown(code)) {
            tag = richTag;
        } else tag = brokeTag;

        return gifService.getGif(tag);
    }

    @GetMapping("/getCodes")
    public List<String> getCodes() {
        return rateService.getCodes();
    }


}
