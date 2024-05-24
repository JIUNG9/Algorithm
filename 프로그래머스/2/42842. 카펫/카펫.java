import java.util.*;

class Solution {
    List<List<Integer>> factors;
    public int[] solution(int brown, int yellow) {        
        int sum = brown + yellow;
        factors = new ArrayList<>();
        
        for(int i = 3; i <= sum; i++){
            if(sum%i == 0) {
                if(i > sum / i) break;
                factors.add(List.of(i, sum / i));
            }
        }
        
        for(List<Integer> factor: factors){
            int small = factor.get(0);
            int big = factor.get(1);
            int brownNumberWithSmallAndBig = (small+big) * 2 -4;
            if(brownNumberWithSmallAndBig == brown) return new int[]{big,small};
        }
            return new int[]{-1,-1};
    }
}