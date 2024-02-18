# [level 2] 괄호 회전하기 - 76502 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/76502) 

### Consideration
1. do the left shift the number of input length
2. find the right bracket


### Check the bracket is valid

- when the character is '(', '{', '[' input the stack. otherwise, the character ')', '}', ']' peek from the stack. if there is appropriate matched bracket pop. if the stack is empty return false.(because there is not matched bracket), when the loop is end the length of the input check the number of remained elements if there is return false(this meant there is no matched bracket)
```
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

```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
