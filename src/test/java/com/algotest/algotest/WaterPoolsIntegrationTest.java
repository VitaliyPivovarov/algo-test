package com.algotest.algotest;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.algotest.algotest.controller.APIs.BASE;
import static com.algotest.algotest.controller.APIs.WATER_POOLS;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@RunWith(SpringRunner.class)
class WaterPoolsIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    @DisplayName("should return 9")
    void shouldReturn9() throws Exception {
        List<String> values = Arrays.asList("5", "2", "3", "4", "5", "4", "0", "3", "1");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.addAll("landscape", values);

        mockMvc.perform(MockMvcRequestBuilders.get(BASE + WATER_POOLS).accept(MediaType.APPLICATION_JSON_VALUE)
                        .params(params))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squaresOfWater").value(9));
    }

    @Test
    @DisplayName("should return 8")
    void shouldReturn8() throws Exception {
        List<String> values = Arrays.asList("1", "4", "2", "3", "5", "2", "3", "6");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.addAll("landscape", values);

        mockMvc.perform(MockMvcRequestBuilders.get(BASE + WATER_POOLS).accept(MediaType.APPLICATION_JSON_VALUE)
                        .params(params))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squaresOfWater").value(8));
    }

    @Test
    @DisplayName("should return 3")
    void shouldReturn3() throws Exception {
        List<String> values = Arrays.asList("3", "3", "3", "2", "1", "3");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.addAll("landscape", values);

        mockMvc.perform(MockMvcRequestBuilders.get(BASE + WATER_POOLS).accept(MediaType.APPLICATION_JSON_VALUE)
                        .params(params))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squaresOfWater").value(3));
    }
}
