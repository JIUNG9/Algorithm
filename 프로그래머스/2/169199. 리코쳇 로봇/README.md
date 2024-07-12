# [level 2] 리코쳇 로봇 - 169199 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/169199) 
### Logical
- Move until right before reached to the map length or width or there is the obstracle which is not visited before.  when reached to the target return the iteration number from start. it moves like sliding until met the condition above described above.

### Impl
- BFS: It is related about the shortest path, So use the BFS
 What should be in the Queue? Location(x,y) and the counter which is currently moved from the start
- About moving. -> move until right before reached to map ended or obstacle
- About using the Instance from the Object(Location) should be initialized the Location when poll() the Location from the Queue -> because the Location is in the heap so it is just change the reference not the just value

``` java
  while(true)
  move()
  if(currentLocation is end of Map or Obstacle) stepBack();          
```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
