import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        
        
        //어떠한 부분에서 1 -1 1 혹은 -1 1 -1 등을 곱하며 그것들의 합이 가장 큰 부분을 구하여라(전체에서 부분을 구하여라) -> 순서는 바뀌면 안 된다.
        //2 -3 -6 -1 3 1 -2 4 
        //-2 3 6 1 -3 -1 2 -4
        // 두 가지 방식으로 -1과 1을 곱하여 구한다.
        
        //Window 풀이 방식
        int len = sequence.length;
        int[] first = makePulse(sequence, -1);
        int[] second = makePulse(sequence, 1);
        
        return Math.max(getMax(first),getMax(second));
 
        
    }
    
    public long getMax(int[] first){
        long answer = first[0];
        long max = first[0]; // this is what I missed if the size is 1
        int len = first.length;
        
       for(int i = 1; i < len; i++){
            if(answer + first[i] < first[i]){
                  answer = first[i];  
            } 
            else{
                answer+=first[i];
                max = Math.max(answer,max);
            }
        }
        return max;
    }
    
    public int[] makePulse(int[] sequence, int startMultiplyValue){
        int[] arr = new int[sequence.length];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sequence[i] * startMultiplyValue;
            startMultiplyValue*=-1;
        }
        return arr;
    }
}