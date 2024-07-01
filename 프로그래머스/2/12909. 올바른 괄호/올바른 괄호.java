import java.util.*;
class Solution {
    
    Stack<Character> stk;
    boolean solution(String s) {
        stk = new Stack<>();
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            char currentC = s.charAt(i);
            if(currentC == '(') stk.push(currentC);
            else{
                if(!stk.isEmpty()) stk.pop();
                else return false;
            }
        }
        if(stk.isEmpty()) return true;
        return false;

        
        

        
    }
}