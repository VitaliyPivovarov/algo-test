package com.algotest.algotest.service.impl;

import com.algotest.algotest.service.WaterPoolsService;
import com.algotest.algotest.service.calculate.CalculateWaterAmount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WaterPoolsServiceImpl implements WaterPoolsService {

    private final CalculateWaterAmount calculateWaterAmount;

    @Override
    public long calculateWaterAmount(int[] landscape) {
        return calculateWaterAmount.calculate(landscape);
    }
}
