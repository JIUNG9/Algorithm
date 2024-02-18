# [level 2] 귤 고르기 - 138476 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/138476) 

### Consideration
1. sort the array
2. Get the weight about same element
3. count from the biggest number which the sum of the elements is bigger than input "k"

### Alternative

below of code is for counting the weight about same element
```
    for (int i = 0; i < len - 1; ) {
      if (tangerine[i] == tangerine[i + 1]) {
        weight[j] = ++counter;
      } else {
        j += 1;
        counter = 1;
        weight[j] = 1;
      }
      i++;
    }
```

but can HashMap be used for counting the same element easily "getOrDefault" method will be useful


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
