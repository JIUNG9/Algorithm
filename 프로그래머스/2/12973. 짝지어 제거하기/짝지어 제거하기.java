import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stk = new Stack<>();
        
        stk.push(s.charAt(0));

        
        for(int i = 1; i < s.length(); i++){
            if(!stk.isEmpty() && stk.peek().equals(s.charAt(i))){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }   
        }
        
        if(stk.size()%2==1) return 0;
        
        while(!stk.isEmpty()){
            Character top = stk.pop();
            Character next = stk.pop();
            if(!top.equals(next)) return 0;
        }
        return 1;
        
       
        
    
        
    }
    

}