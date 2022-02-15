package com.service;

import com.client.FeignGifClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class gifServiceImplTest {
    @Mock
    private FeignGifClient feignGifClient;

    @Value("${openexchangerates.app.id}")
    private String app_id;

    private gifServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new gifServiceImpl(feignGifClient);
    }

    @Test
    void getGif() {
        underTest.getGif("rich");
        verify(feignGifClient).getGif("rich", app_id, "1", "1");
    }
}