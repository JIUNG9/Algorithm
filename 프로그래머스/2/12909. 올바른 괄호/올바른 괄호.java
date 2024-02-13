import java.util.Stack;


class Solution {
public boolean solution(String s) {

    //1. make two stacks A and B
    //2. save the all elements At A stack from rear
    //(loop) termination :
    // If A stack is empty and B is not return false
    // If A stack is empty and B is empty return true
    // => this mean iterate while A is empty
    //if(b.isEmpty()) b.push(a.pop())

    
    

    
    Stack<Character> a = new Stack<>();
    Stack<Character> b = new Stack<>();
    int len = s.length();
    
    if(len%2==1) return false;
    
    //push all elements from rear
    for(int i = len-1; i >= 0; i--){
      a.push(s.charAt(i));
    }

    while(!a.isEmpty()){
      if(b.isEmpty()) b.push(a.pop());
      if(b.peek()=='(' && a.peek()==')'){
        b.pop();
        a.pop();
      }
      else{
        b.push(a.pop());
      }
    }
    return b.isEmpty();
  }
}