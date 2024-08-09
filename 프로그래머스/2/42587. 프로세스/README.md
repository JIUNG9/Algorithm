# [level 2] 프로세스 - 42587 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42587) 

### Approach
- "각 작업은 우선순위와 각 위치의 idx가 존재한다. 작업의 우선순위가 현재 작업 중 가장 우선 순위가 크다면 해당 작업을 수행하고 그렇지 않다면 현재 확인 하는 작업을 가장 후순위로 미룹니다. 해당 작업을 반복하다 location과 해당 작업의 idx가 일치하면 현재까지 반복한 횟수를 반환합니다. -> "각 작업은 우선순위와 각 위치의 idx가 존재한다. 작업의 우선순위가 현재 작업 중 가장 우선 순위가 크다면 해당 작업을 수행하고 그렇지 않다면 현재 확인 하는 작업을 가장 후순위로 미룹니다. 해당 작업을 반복하다 location과 해당 작업의 idx가 일치하고 우선순위가 현재 진행해야하는 우선순위라면 작업ㅇ르 수행하고 현재까지 반복한 횟수를 반환합니다."
- I missed the condition when curernt idx is matched with loaction also should check the priority and do the task, finally return the counter

### Impl
- Use the PrioirtyQueue -> for checking current checked job has the most prirority
- Use the Queue -> when current checking job doesn't have the priority should be inserted the last position

### Pesudo
``` java
PrioirtyQueue<Integer> priorityQ;
Queue<Task> tasks;
main(){
initTheQueue();
while(!q.isEmpty())
  Task currentTask = q.poll();
  if(currentTask.priority == priority.peek() && currentTask.idx == answerLocation)  counter++; break;
  else if(currentTask.priority == priority.peek() counter++;
  else q.add(currentTask);
    return counter;


}

```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
