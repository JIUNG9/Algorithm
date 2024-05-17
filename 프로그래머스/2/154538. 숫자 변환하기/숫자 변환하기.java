import java.util.*;
class Solution {
    private int answer = -1;
    Queue<int[]> q;
    
    public int solution(int x, int y, int n) {
        q = new LinkedList<>();
        q.add(new int[]{y, 0});
        
            while(!q.isEmpty()){
                int[] arr  = q.poll();
                int value = arr[0];
                int counter = arr[1];
                if(value == x) {
                    answer = counter;
                    break;
                }
                if(value - n > 0) q.add(new int[]{value-n,counter+1});
                if(value % 2 == 0 && value / 2 > 0) q.add(new int[]{value /2,counter+1});
                if(value % 3 == 0 && value / 3 > 0) q.add(new int[]{value / 3, counter+1});
            }  
        return answer;
        
    }

}