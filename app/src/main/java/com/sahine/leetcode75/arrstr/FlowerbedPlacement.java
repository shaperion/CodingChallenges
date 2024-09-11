package com.sahine.ArrStr;

class FlowerbedPlacement {
	public FlowerbedPlacement(){}
	
    public boolean uniformCanPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++){
            boolean left = i == 0 || flowerbed[i - 1] != 1 ? true : false;
            boolean right = i == flowerbed.length - 1 || flowerbed[i+1] != 1 ? true : false;

            if(left && right && flowerbed[i] == 0){
				if(n == 0)break;
                n--; flowerbed[i] = 1;
            }
        }

        return n == 0 ? true : false;
    }
	
	public boolean edgeCanPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;

        if(len == 1 && flowerbed[0] == 0) n--;

        int i = 0;
        while(i < len - 2){
            if(flowerbed[i] == 1){
                i += 2;
            }
            else if(flowerbed[i] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                i += 2;
                n--;
            }else i++;
        }
        if(len >= 2){
            if(flowerbed[len-1] == 0 && flowerbed[len-2] == 0) n--;
        }
        
        return n <= 0;
    }
}