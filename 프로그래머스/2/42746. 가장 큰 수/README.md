# [level 2] 가장 큰 수 - 42746 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42746#) 

### Approach
- Sort by number by the first letter size desc order
- If the first letter is the same should check the combination which one is bigger when combined two numbers first case is first int come first, and second case first num comes next. Compare with them sort by desc order.


### Implementation
- mis-used -> Arrays.stream() return the intStream which use the primitive int type. so for using Boxed type of operation alike sorted((i1,i2)->{Integer.compare(i1,i2))) should use the boxed() method as intermediate operation
- The return type is the String, When the number is the "000" like there are only cosisted with '0'. should be returned as 0, Integer.parseInt() and String.valueOf() is logically not wrong. but the range is over the int.

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
