import java.util.*;
class Solution {
    boolean solution(String s) {
        //바르게 짝 지어졌다. 순서가 필요하다. -> Stack, Queue
        //왼쪽 괄호가 두 개라면 오른쪽 괄호도 두 개가 나와야한다.
        //그리고 모든 게 끝났을 때 stk에 남는 개수가 없어야한다.
        //구현 스택을 사용해서 왼쪽 괄호라면 스택에 넣고 오른쪽 괄호일 때 해당 스택에 왼쪽 괄호가 존재하는지 확인한다 만약 존재 하지 않는다면 false를 리턴한다.
        
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(') stk.push('(');
            else{
                if(stk.isEmpty()) return false;
                stk.pop();
            }
        }
        return stk.isEmpty();
        
    }
}