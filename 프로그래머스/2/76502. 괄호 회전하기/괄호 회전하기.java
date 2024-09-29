import java.util.*;
class Solution {
    private int answer = 0;
    public int solution(String s) {
        
        //하나씩 문자열을 옮기면서
        //모양별로 순서별로 괄호가 와야한다.
        //{, [, ( 라면 상태를 저장하고 이후 닫히는 괄호 ), ], } 가 왔다면 이전에 상태를 저 장한 것의 최근 것과 모양이 일치해야한다. 만약 모양이 일치하지 않는다면 해당 괄호는 조건을 충족하지 않는다. 만약 충족한다면 가장 최근에 저장한 것을 삭제한다. 이렇게 모든 문자열을 검사했을 떄 저장한 열린 괄호가 없다면 해당 문자열은 조건을 충족한다. 저장된 열린 괄호가 있다는 것은 적절히 닫히지 않았다는 것을 의미
        for(int i = 0; i < s.length(); i++){
            if(i!=0) s = leftShift(s);
            if(isRightBracket(s)) answer++;
        }
        return answer;
        
        
    }
    public String leftShift(String s){
        //num만큼 제외한 앞 문자열에서 해당 제외한 문자열을 뒤에 붙인다.
        s = s.substring(1, s.length()) + s.substring(0, 1);
        return s;
    }
    
    
    public boolean isRightBracket(String s){
        
         Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' )
            {
                stk.push(s.charAt(i));
                continue;
            }
            else{
                if(stk.isEmpty()) return false;
                
                if(s.charAt(i) == ')'){
                    if(stk.peek()!='(') return false;
                }
                else if(s.charAt(i) == ']'){
                    if(stk.peek()!='[') return false;
                }
                else if(s.charAt(i) == '}'){
                    if(stk.peek()!='{') return false;
                }
                //missed point -> I put the else statement. the inner condition from has the only closed bracket so using this else statement won't be happended
                    stk.pop();
                
            }
        }
        return stk.isEmpty();
        
    }
}