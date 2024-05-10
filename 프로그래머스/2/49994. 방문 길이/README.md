# [level 2] 방문 길이 - 49994 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/49994) 

## Approach

### Logical
- can't use the route already went throgh even start position is different.
-> Use the Set as the solution. add the both side of direction when range is satisfied and not use that route.
### Missed
I thought When overriding the equals and hash. I thought, Adding only one side of Person which has the current dimension, and the position will be moved has the same hash code. But I didn't. So add the each of Person at Set which is directly to target and target to from will gurantee the this problem condition
### Pesudo
```java
Person{
willBeMovedX
willBeMovedY
currentX
currentY

updateX()
updateY()
}
main{
while(loop the input element)
        Person p = (currentDimension, willBeMovedDimension);
        Person reversedP = (willBeMovedDimension,currentDimension);
        if(!set.contains(p) && !set.contains(reversedP) && rangeIsSatisfied(willBeMovedDimension)) set.add(p) set.add(reversedP) counter++

        if(rangeIsStatisFied(willBeMovedDimension) p.updateX, p.updateY


                return counter
}
```


  

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
