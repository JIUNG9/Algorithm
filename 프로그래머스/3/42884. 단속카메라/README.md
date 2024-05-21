# [level 3] 단속카메라 - 42884 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42884) 

### Approach
- check the overlapped element will takes O(n^2) and the input size is the 10,000. So use the another approach for handling this problem.
- Use the greedy.
   when the start position is overlapped by previous end time doesn't need to set the camera. Just set the camera only for end time.
  and when end position is not bigger than start position idx. set the camera and check from the current checking start camera idx.
  when start position idx exceed the range of length. This means there is no overlapped element at last route. and There is overlapped element at last both of cases are included. so add the camera + 1 at last

``` java


while(startPositionIdx < len && endPositionIdx< len)

if( routes[startPositionIdx][0] <= routes[endPositionIdx][1])
        move startPosition to rear
else endPosition = startPositionIdx; camera++


return camera + 1 ;

```

  

-    출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
