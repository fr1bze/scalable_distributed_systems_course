package com.example.not_simple_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SimpleController.class)
class SimpleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MapRepository mapRepository;

    @Test
    void testPutAndGetValue() throws Exception {
        when(mapRepository.get("firstKey")).thenReturn("firstValue");

        mockMvc.perform(post("/api/put")
                        .param("key", "firstKey")
                        .param("value", "firstValue"))
                .andExpect(status().isOk())
                .andExpect(content().string("Saved: firstKey -> firstValue"));

        mockMvc.perform(get("/api/get/firstKey"))
                .andExpect(status().isOk())
                .andExpect(content().string("firstValue"));
    }

    @Test
    void getEmptyValue() throws Exception {
        when(mapRepository.get("ratata")).thenReturn("empty");

        mockMvc.perform(get("/api/get/ratata"))
                .andExpect(status().isOk())
                .andExpect(content().string("empty"));
    }

}
