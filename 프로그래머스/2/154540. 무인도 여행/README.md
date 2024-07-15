# [level 2] 무인도 여행 - 154540 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/154540) 

### Approach
- Check all of the elements. and when current checking element is not 'X' add the current value and handle as visited and Check all of the forward position with each direction from current position If it is not visited before, and not also 'X', and there' is not the wall(range check), sum of that value and mark as visited, and visit

#### Impl
- BFS: what should be in the Queue? -> The location, not the counter, because it is not the case which find the shortest path. Just get the sum of value.

``` java
Queue<Location> q;
boolean[] visited;
List<Integer> answerList;

main(){
for(iterate the len)
        for(iterate the width)
                if(current is not 'X' && !visited current)
                        counter += currentValue;
                        current visited as true
                        q = new LinkedList<>();
                        q.add(currentPosition)
                        while(!q.isEmpty())
                                Positon position = q.poll();
                                for(each side check)
                                        if(current side forward is not visited and range is fine and not 'X')
                                                visited currentCheck as true
                                                counter+=currentValue;
                                                q.add(currentPosition);

                        answerList.add(counter);
sort by the asc, and return with array
;}
```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
