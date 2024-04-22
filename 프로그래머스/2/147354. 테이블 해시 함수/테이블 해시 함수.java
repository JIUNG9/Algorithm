import java.util.*;

class Solution {
    
    public int solution(int[][] data, int col, int rb, int re) {
        
        List<Integer> list = new ArrayList<>();
        int colIdx = col -1;
        int sum = 0;
        
        Arrays.sort(data, (arr1, arr2) ->{
            int result =Integer.compare(arr1[colIdx],arr2[colIdx]);
            if(result == 0){
                return Integer.compare(arr2[0], arr1[0]);
            }
            return result;     
            
        });
        
        for(int i = rb -1 ; i <= re -1; i++){
            list.add(getArrElementSumOfMod(data[i],i+1));

        }
        
        for(Integer i : list){
            sum = (sum ^ i);
        }
            return sum;        
        
    }
    public int getArrElementSumOfMod(int[] arr, int input){
        int sum = 0;
        for(Integer i : arr){
            sum+=(i%input);

        }
            return sum;
        }
}