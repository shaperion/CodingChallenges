package java.com.sahine.ArrStr;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class GreatestCandies {
	public GreatestCandies(){}
	
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatestCandies = -1;
        int n = candies.length - 1;
        Boolean[] kids = new Boolean[candies.length];
        
        for(int i = 0; i <= n; i++){
            if(i <= n - i){
                if(greatestCandies < candies[i]){
                    greatestCandies = candies[i];
                }
                if(greatestCandies < candies[n - i]){
                    greatestCandies = candies[n - i];
                }
            }
            if (i >= n - i){
                kids[i] = greatestCandies <= (candies[i] + extraCandies);
                kids[n - i] = greatestCandies <= (candies[n - i] + extraCandies);
            }
        }
        List<Boolean> result = new ArrayList<>(Arrays.asList(kids));
        return result;
    }
}