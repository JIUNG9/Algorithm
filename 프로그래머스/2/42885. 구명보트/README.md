# [level 2] 구명보트 - 42885 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42885) 

### Consideration
- Greedy
1. arrange by AESC for using the two pointer
2. (iteration) when arr[left] is exceeded the weight just move the left pointer and increase the counter
3. (iteration) when sum of arr[left] and arr[right] is equla or smaller than limit increase the left pointer and decrease the right pointer. and also increase the counter
4. (iteration) when arr[left] + arr[right] is bigger than limit decrease the right pointer and also increase the counter(fourth consideration doesn't check the case of arr[left] is bigger than limit. already check the first consideration)

```
public int solution(int[] people, int limit) {
    int len = people.length;
    int left = 0;
    int right = len-1;
    int counter = 0;
    Arrays.sort(people);

    while(left <= right){
      if(people[left] >= limit) {
        left++;
        counter++;
      }
      else if (people[left] + people[right] <= limit){
        counter++;
        left++;
        right--;
      }
      else if(people[left] + people[right] > limit)
      {
        counter++;
        right--;
      }
    }
      return counter;

    }
```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
