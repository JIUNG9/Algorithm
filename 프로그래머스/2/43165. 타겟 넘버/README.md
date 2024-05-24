# [level 2] 타겟 넘버 - 43165 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43165) 

### Missed point
- Array is in the heap area.
- use the post ++ operator won't work as expected. it just input the same value and increase after.


### Approach
- with input elements, add or subtract for each element make the target number. If so increase the answer counter. but should use all of elements
- can't use the visited array. even use the visited array. the pop of idx is iterated by the for loop. and this work-flow is not problem suggest
  
```java

dfs(int sum, int target, int idx, int[] numbers){

        if(sum == target && idx == numbers.length) counter++;
        if(idx < numbers.length)
                dfs(numbers[idx]+ sum, target , idx+1, numbers);
                dfs(numbers[idx] -sum, target , idx+1, numbers); 


}

```
 



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
