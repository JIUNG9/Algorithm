# [level 2] N개의 최소공배수 - 12953 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12953) 

### Approach

- Get the least common multiple from two of input until there is a one element in list, For getting the least common multiple, get the gcd.
- For getting gcd, get the max value from 1 to under the smaller input value which is remainder operation result is 0.
- And remove the two of input and insert the current least common multiple value

```
list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
while(list.size > 1 )
int first = list.get(0);
int second = list.get(1);
int gcd = getGcd(first, second);
int lcm = first / gcd * second;
list.remove(0);
list.remove(0);
list.add(lcm);


return list.get(0);
```


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
