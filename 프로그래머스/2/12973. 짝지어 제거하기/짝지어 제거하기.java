import java.util.Stack;


class Solution
{
 public int solution(String s) {

    Stack<Character> stackA = new Stack<>();
    Stack<Character> stackB = new Stack<>();
    int len = s.length();
    for (int i = 0; i < len; i++) {
      stackA.push(s.charAt(i));
    }       

    stackB.push(stackA.pop());

    while (!stackA.isEmpty()) {
      char temp = stackA.pop();
      if(!stackB.isEmpty()&&stackB.peek()==temp){
        stackB.pop();
      }
      else{
        stackB.push(temp);
      }
    }
 
    while (!stackB.isEmpty()) {
      char c = stackB.pop();
      if (stackB.isEmpty() || c != stackB.pop()) {
        return 0;
      }
    }
    return 1;
  }
}

