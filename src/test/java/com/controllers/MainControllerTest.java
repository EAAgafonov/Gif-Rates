package com.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.gifServiceImpl;
import com.service.rateServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@WebMvcTest(MainController.class)
class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private gifServiceImpl gifService;
    @MockBean
    private rateServiceImpl rateService;

    @Value("${giphy.rich}")
    private String richTag;
    @Value("${giphy.broke}")
    private String brokeTag;
    @Value("${openexchangerates.app.id}")
    private String app_id;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    void whenGifIsRich() throws Exception {

    }

    @Test
    void whenCodesAreNull() throws Exception {
        Mockito.when(rateService.getCodes())
                .thenReturn(null);
        mockMvc.perform(get("/gif/getCodes")
                .content(mapper.writeValueAsString(null))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0]").doesNotExist());
    }
}