import java.util.Stack;


class Solution {
 public int solution(String s) {
    int len = s.length();
    int counter = 0;

    for (int i = 0; i < len; i++) {
      String leftShifted = leftShift(s, i);
      if (isCorrectBracket(leftShifted)) {
        counter++;
      }
    }
    return counter;
  }

  public boolean isCorrectBracket(String s) {

    int len = s.length();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < len; i++) {
      if (s.charAt(i) == '(') {
        stack.push(s.charAt(i));
      }
      else if (s.charAt(i) == '{') {
        stack.push(s.charAt(i));
      }
      else if (s.charAt(i) == '[') {
        stack.push(s.charAt(i));
      }
      else if(s.charAt(i) == ')'){
        if(stack.isEmpty() || stack.peek()!='(') return false;
           else{
          stack.pop();
        }
      }
       else if(s.charAt(i) == '}'){
        if(stack.isEmpty() || stack.peek()!='{') return false;
        else{
          stack.pop();
        }
      }
        else if(s.charAt(i) == ']'){
        if(stack.isEmpty() || stack.peek()!='[') return false;
           else{
          stack.pop();
        }
      }
    }
    return stack.isEmpty();
  }

  public String leftShift(String s, int i) {
    String temp = s.substring(0, i);
    String withoutSuffix = s.substring(i);
    return withoutSuffix.concat(temp);
  }
}