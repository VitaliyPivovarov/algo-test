package com.algotest.algotest.service.calculate.impl;

import com.algotest.algotest.service.calculate.CalculateWaterAmount;
import org.springframework.stereotype.Service;

@Service
public class Point2Impl implements CalculateWaterAmount {

    @Override
    public long calculate(int[] landscape) {
        if (landscape.length <= 2) return 0;

        int leftPoint = 0;
        int rightPoint = landscape.length - 1;
        int leftPointMax = 0;
        int rightPointMax = 0;
        int squaresOfWater = 0;

        while (leftPoint < rightPoint) {

            if (landscape[leftPoint] < landscape[rightPoint]) {
                if (landscape[leftPoint] >= leftPointMax) {
                    leftPointMax = landscape[leftPoint++];
                } else {
                    squaresOfWater += leftPointMax - landscape[leftPoint++];
                }
            } else {
                if (landscape[rightPoint] >= rightPointMax) {
                    rightPointMax = landscape[rightPoint--];
                } else {
                    squaresOfWater += rightPointMax - landscape[rightPoint--];
                }
            }
        }
        return squaresOfWater;
    }
}
