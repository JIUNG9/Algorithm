# [level 3] 단어 변환 - 43163 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43163) 

### Approach
1. Check the all of the cases which is coplied the rule the only one chracter can be changed from the origin and the number of minimum path from start to target is the answer
2. From first condition Use the permutation. This meant DFS with for loop can handle this approach
3. Logical : When the only one character is different compare with origin and target, and not visited before visit and count, when reach to the last target count the counter. and compare with answer. the minimum value is the answer.
4. DFS : what should be in stack, and what should not be in stack -> answer, and counter should not be in stack. the counter should be increased by the condition is matched not by the stack is pop and push

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
