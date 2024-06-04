# [level 3] 베스트앨범 - 42579 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42579) 

### Approach

- logical: Group by genere, Get Two of the most played idx by genere descending order from the sum of played music.
- implementation :
- Group by genre -> Use the HashMap
- Get Two of the most played idx -> It will be sorted while handling the input data -> Prioirty Queue
- The sum of played music -> should be sorted after the data is set -> Use the Intstream.


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
