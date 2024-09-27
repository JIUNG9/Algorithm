import java.util.*;

class Solution
{
    public int solution(String s)
    {
        //이전의 문자열과 현재 문자열이 같다면 이전의 문자열과 현재 문자열을 지운다. 이후 지운 것을 제외한 나머지 문자열을 반복한다. 만약 stk가 비었다면 1을 반환 비지 않았다면 0을 반환한다.
        //순서와, 상태를 가져야하는 문제
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        int len = s.length();
        for(int i = 1; i < len; i++){
            if(!stk.isEmpty() && stk.peek() == s.charAt(i)){
                stk.pop();
                continue;
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        
        for(int j = 0; j < stk.size(); j++){
            if(stk.size() == 1) return 0;
            if(stk.size() % 2 == 1 || (stk.pop() != stk.pop())) return 0;
        }
        return 1;
        
      
    }
}