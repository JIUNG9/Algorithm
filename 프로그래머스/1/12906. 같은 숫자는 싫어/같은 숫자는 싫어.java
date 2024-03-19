import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        
        
        for(int i = 1; i < arr.length; i++){
            if(stk.peek()!= arr[i]) stk.push(arr[i]);
        }
        
        int[] answer = new int[stk.size()];
        int idx = 0;
        for(int i = stk.size()-1; i >= 0; i--){
            answer[i] = stk.pop();
        }


        return answer;
    }
}