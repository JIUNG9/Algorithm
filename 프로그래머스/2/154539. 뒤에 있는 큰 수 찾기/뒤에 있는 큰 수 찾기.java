import java.util.*;
class Solution {
    private Stack<int[]> stk;
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        stk = new Stack<>();
        int[] answer = new int[len];
        Arrays.fill(answer,-1);
        stk.push(new int[]{0, numbers[0]});
        
        for(int i = 1; i< len; i++){
            
            int currValue = numbers[i];
            
            while(!stk.isEmpty()&& stk.peek()[1] < currValue){
                int[] lastElement = stk.pop();
                int idx = lastElement[0];
                int value = lastElement[1];
                answer[idx] = currValue;
                
            }
            stk.push(new int[]{i,numbers[i]});
        }
        return answer;
        
    }
}