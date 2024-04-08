# [level 3] 숫자 게임 - 12987 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12987) 

### Approach
- preq: sort for  comparing both A and B
  
- case 1: lose -> find the B[bIdx] which is bigger than A[aIdx] after then  bIdx is out of range. there is no bigger value at B. so break the loop else increase bIdx, aIdx and answer
- case 2: win -> increase the aIdx, bIdx and increase the answer
- case 3: draw -> move the bIdx. for winning


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
