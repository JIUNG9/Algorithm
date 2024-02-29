# [level 2] 프로세스 - 42587 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42587) 


### Consideration
"큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다"
This means should consider the priority value so input all of the elements into the Queue and get array by DESC order. so current polled element is not max value. put queue again 

``` java
 while(!q.isEmpty()){
      int[] polled = q.poll();
      int alpha = polled[0];
      int priority = polled[1];

      if (alpha == l && priority == max) {
        counter++;
        break;
      }
        if (priority != max) {
          q.add(polled);
        } else {
          counter++;
          idx++;
          max = maxDESC.get(idx);
        }
      }
```

- How to get reverse order by arr

``` java
list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
``` 



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
