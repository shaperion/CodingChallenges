package com.sahine.ArrStr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlowerbedPlacementTest {
	
    @Test void uniformCanPlaceFlowersTest() {
		// Parameters
		int[] flowerbed = {1,0,0,0,1};
		int n = 1;
		// Initialize Application
        FlowerbedPlacement classUnderTest = new FlowerbedPlacement();
        assertTrue(classUnderTest.uniformCanPlaceFlowers(flowerbed, n));
    }
	
	@Test void edgeCanPlaceFlowersTest() {
		// Parameters
		int[] flowerbed = {1,0,0,0,1};
		int n = 1;
		// Initialize Application
        FlowerbedPlacement classUnderTest = new FlowerbedPlacement();
        assertTrue(classUnderTest.edgeCanPlaceFlowers(flowerbed, n));
    }
}