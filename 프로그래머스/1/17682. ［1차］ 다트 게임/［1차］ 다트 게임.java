import java.util.*;
class Solution {
    public int solution(String s) {
        
        int sum = 0;
        Stack<Integer> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            
        if(Character.isDigit(c)){
            int value = Character.getNumericValue(c);    
            if(Character.isDigit(s.charAt(i+1))){
                stk.push(10);
                i++;
             }
            else{
                stk.push(value);
                 }
                 }
                 

             if(c=='D'){
                int val = stk.pop();
                stk.push(val * val);
            }
             if(c == 'T'){
                int val = stk.pop();
                stk.push(val * val * val);
            }
             if(c == '*'){
                if(stk.size() <= 1){
                    int val = stk.pop();
                    stk.push(val*2);
                }
                else{
                    int val1 = stk.pop();
                    int val2= stk.pop();
                    stk.push(val2*2);
                    stk.push(val1*2);
                }
            }
             if(c == '#'){
                int val = stk.pop();
                stk.push(val * -1);
            }
         
        }
        
        while(!stk.isEmpty()){
            int value = stk.pop();
            sum+=value;
        }
        return sum;
        
    }
    
    
    
}