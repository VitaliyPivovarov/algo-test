package com.algotest.algotest.controller;

import com.algotest.algotest.controller.dto.WaterPoolDto;
import com.algotest.algotest.service.WaterPoolsService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import static com.algotest.algotest.controller.APIs.BASE;
import static com.algotest.algotest.controller.APIs.WATER_POOLS;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(BASE + WATER_POOLS)
public class WaterPoolsController {

    private final WaterPoolsService waterPoolsService;

    @Operation(
            summary = "Calculate water amount"
    )
    @GetMapping
    public WaterPoolDto calculateWaterAmount(@RequestParam int[] landscape) {
        return new WaterPoolDto(waterPoolsService.calculateWaterAmount(landscape));
    }

}
