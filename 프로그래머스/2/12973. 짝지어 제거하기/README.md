# [level 2] 짝지어 제거하기 - 12973 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12973) 

- set the temp from the first element, and the next element from the input is matched remove the temp and current checking element, otherwise input the temp(There can be over the two of elements in storage)
  after checking the all elements in input. check the storage. when the all pair elements are matched sequentially in storage it is true otherwise false
- by above logical analyze, need the storage and order is matter. so decide to use the stack

 
 
``` java

main(String input){

Stack<Character> stk;
stk.push(firstElement)
while(iterate all elements){
 if(stk.peek().equals(currentCheckElement)) stk.pop()
 else stk.push(currentCheckElement)
}

if(stk.size()%2==1) return false;
while(
 if(sequentially pop from the stk is not matched) return 0;
}
return 1;

```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
