# [level 2] 기능개발 - 42586 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42586) 

### Approach
- Missed point -> I set the range <= 100. This meant even the progress is reached out the 100 push the new progress over 100 will be pused into the schedule(Stack). Fix to < 100 worked well!

- When the prior proccess is done check the rior proccess from current If rior side of proccess also done deploy the sequentional processes and do not cover from now on, iterate this until there is no proccess should be hand

```java

init()
addToStackList the Stack(the progress with proccess until progress 100);// 진행 작업도가 100일때 까지( < 100)

procceed()
pop the proccess when day after If progress is under 100;

theCounterOfDeployedToday(){
        while(firstElement of Stk is empty() and range check) counter++;
        return counter;
}

```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
