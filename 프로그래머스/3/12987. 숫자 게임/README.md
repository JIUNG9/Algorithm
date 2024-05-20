# [level 3] 숫자 게임 - 12987 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12987) 

### Approach
#### Greedy
- Sorted both of arrays. and move the pointer of B until B element is bigger than A element -> Greedy approach(Use the pointer)



#### Pseudo
``` java

Arrays.sort(A);
Arrays.sort(B);
while(aPointer < aLen && bPointer < bLen)
  if(B[bPointer] > A[aPointer]) answer++; aPointer++; bPointer++;
  else bPointer++;

return answer;
```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
