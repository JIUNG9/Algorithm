# [level 3] 연속 펄스 부분 수열의 합 - 161988 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/161988) 

### Approach
- when the value  which was added with the current value from the max is more smaller than current value. Update the current value as the max. otherwise the add from the current value. when added from the current value compare with the max value. If the result of add is more bigger than the max. update the max.(This is the window algorithmn)

### Missed Point
- The number of element can be 1. so when start from the 1 index. the answer can't be updated.
- long type. The min value of the sqeunce is the -100,000 and multiply 500,000 will be out of range of Integer

### Impl
- For getting purse part. should multiply twice(start with -1 or 1)
- By dividing the two phase. also calculate the twice for getting max

<p>주어진 수열의 연속 부분 수열 [3, -6, 1]에 펄스 수열 [1, -1, 1]을 곱하여 연속 펄스 부분 수열 [3, 6, 1]을 얻을 수 있고 그 합은 10으로서 가장 큽니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
