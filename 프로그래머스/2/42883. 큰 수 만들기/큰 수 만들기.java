import java.util.*;
class Solution {
    public String solution(String number, int k) {
     
        int answerLen = number.length() - k;
        
        Stack<Character> stk = new Stack<>();
        
        
        for(int i =0; i< number.length(); i++){
                while(!stk.isEmpty() && number.charAt(i) > stk.peek() && k > 0){
                    stk.pop();
                    k--;
                }
                stk.push(number.charAt(i));
            }
        
        
        String answer ="";
        for(int j = 0; j < answerLen; j++){
            answer = answer.concat(String.valueOf(stk.get(j)));
        }
        return answer;
    }
}