# [level 2] 큰 수 만들기 - 42883 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42883) 

### Approach
- Remove the Character in String until the removeCounter reach to "K". If the rear value is more bigger than previous values remove the prefix value -> This meant 'Order is matter but the most biggest value should be' -> The implementation of this clause means use the Stack data structure.
- When removeCounter reaches to the 'K' can't remove the Character anymore. so just append the Character with stack.
- The stack is the characteristic of FIFO. So append stack elemetns and reverse()
- finally return the len - k will be the answer

``` java

StringBuilder sb;
Stack<Integer> stk;
stk.push(firstElement);
removeCounter = 0;

while(iterate all elements)
        //when removeCounter reaches to the k. just push into the stk
        if(removeCounter == k) stk.push(currValue); continue;
        //when prior elements is smaller than currentValue, remove the elements(but should check ther stk range, and removeCounter)
        while(stk is not Empty && stk.peek < currValue && removeCounter < k) removeCounter++; stk.pop();
        //when over the while loop the element is bigger than stk.peek() value. 
        stk.push(currvalue);


while(!stk.Empty())
        sb.apeend((String)stk.pop());

return sb.reverse().subString(0, len-k);
```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
