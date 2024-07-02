import java.util.*;
class Solution {
    private int counter = 0;
    public int solution(String s) {
        String moved = s;
        for(int i = 0; i < s.length(); i++){
            if(i == 0) {
                if(isRightBracket(moved)) counter++;
                
            }
            else {
                moved = moveToLeftOnce(moved);
                if(isRightBracket(moved)) counter++;
            }
        }
        return counter;
        
    }
    public String moveToLeftOnce(String s){
        char firstChar = s.charAt(0);
        return  s.substring(1) + String.valueOf(firstChar);
    }
    
    public boolean isRightBracket(String s){
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '(' || c == '{' || c == '[') 
            {
                stk.push(c);
            }
            else{
                if(stk.isEmpty()) return false;
                else{
                                    
                    if(c == ')') if(stk.peek()!= '(') return false; else stk.pop();
                    if(c == '}') if(stk.peek()!= '{') return false; else stk.pop();
                    if(c == ']') if(stk.peek()!= '[') return false; else stk.pop();
                }
            }
        }
        return stk.isEmpty() ? true : false;
    }
    
}