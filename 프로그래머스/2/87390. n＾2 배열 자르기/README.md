# [level 2] n^2 배열 자르기 - 87390 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87390) 

### Approach
- the length of the square is 10^7 so consider all of the cases will take 10^7^2 so just get the case between start row and end row
- The endRow should be cosidered when divided by the "n" and there is the remainder should be contained also +1 row
- After get the elements from the startRow to endRow, the startIdx should be left %n otherwise the endIdx from startIdx to (right - left)


### Impl
- Be cautious when handling the long type. left - right is absolutely int type. but just only left and right is the long type.


``` java
        int startRow = (int)(left/n);
        int startRow (int)left/n
```

above code is the example. should be rounded by the bracket with the result not the "left"

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
