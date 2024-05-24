# [level 1] 모의고사 - 42840 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42840) 

### Approach

- find the rule of each person and declare the array by following the rule
- iterate the answer and find the person who get the most counter of answer
- key point is the using the stream

```java
List<List<Integer>> counterList, // the first index  of List in type of coutnerList is the man idx. and next is the counter of the matched with answer
List<Integer> answerList
counterList =counterList.stream().sorted(sort by the counter of answer, If counter is the same sort by the number of man).collect(Collectors.toList());

int maxValue = counterList.get(0).get(1)
for(iterate coutnerList)
if(maxValue == currentValue of counter) answerList.add(current idx of man);


return answerList.stream().mapToInt(i->i).toArray();

```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges 
