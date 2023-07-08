import java.util.*;
class Solution
{
    public int solution(String s) {

    int len = s.length();
    Stack<Character> stk = new Stack<>();
    stk.push(s.charAt(0));

   for(int i =1; i < len; i++){
     if(stk.isEmpty()) stk.push(s.charAt(i));
     else if(stk.peek() == s.charAt(i)) stk.pop();
     else{
       stk.push(s.charAt(i));
     }
   }
   if(!stk.isEmpty()) return 0;
   return 1;

  }
}