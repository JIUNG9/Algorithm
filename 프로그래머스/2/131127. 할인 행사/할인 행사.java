import java.util.*;
import java.util.stream.*;

class Solution {
    private Map<String,Integer> wantedMap;
    private int counter = 0;
    public int solution(String[] want, int[] number, String[] discount) {
        
        initMap(want,number);
        int discountLen = discount.length;
    
        for(int i = 0; i <  discountLen; i++){
            if(wantedMap.containsKey(discount[i])){
                    int value = wantedMap.get(discount[i]);
                    wantedMap.put(discount[i], value - 1);
            } 
            if(i > 9){
                String beforeBargained = discount[i-10];
                if(wantedMap.containsKey(beforeBargained)){
                    wantedMap.put(beforeBargained, wantedMap.get(beforeBargained)+1);
                }
                }
            if(isMapValuesAllBargained()) {
                counter++;
            }
        }
        return counter;
      
    }
    public boolean isMapValuesAllBargained(){
        return wantedMap.values().stream().filter(i -> i > 0).count() > 0 ? false: true;
    }
    public void initMap(String[] want, int[] number){

        wantedMap = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            wantedMap.put(want[i], number[i]);
        }
    }
    
    public int updateTheQualifedDate(int date){
        
        return date < 10 ? 0 : date-10;
    }
}