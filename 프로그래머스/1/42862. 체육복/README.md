# [level 1] 체육복 - 42862 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42862#) 

### Approach
- Why should consider same element exist at each List and should sorted by asc order -> when 3, 2 / 4, 3 which is not considered removing the same element both of list and not sorted by ascending order, The result should be two of student can't participate the class but not considering removing the same element and not sort will all students can participate the class.

- When to use the List which is converted from the array. can't use the foreach operator with List remove() method. see the below pic. so as a solution make the temp list.
  
``` java
List<Integer> lost
List<Integer> reserve
List<Integer> test

while(iterating all lost elements)
if(lost.contains reserve element) reserve.remove(element); temp.add(element);

while(iterating all reserve element)
if(temp contains temp elemenet) lost.remove(element)

```
  

  
![Pasted Graphic](https://github.com/JIUNG9/Algorithm/assets/60885635/ee6f90ef-c64a-43a5-951a-88f257285e8d)


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
