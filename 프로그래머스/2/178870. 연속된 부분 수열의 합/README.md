# [level 2] 연속된 부분 수열의 합 - 178870 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/178870) 

### Approach
#### init Approach
- Use the two pointer one is for adding the element with sum. and another one is susbtract the element from the sum.
- when the sum is smaller than input k. add the postIdx(for add) and increase the idx
- when the sum is bigger than input k. add the preIdx(for substract) and increase the idx
- to find the smallest the gap size of preIdx, postIdx when the sum is matched with 'k' should check all of the cases

``` java

 while (preIdx < len || postIdx < len) {
      if (postIdx < len && sum < k) {
        sum += sequence[postIdx++];
      } else if(preIdx < len && sum >=k) {
        sum -= sequence[preIdx++];
      }
      if (sum == k) {
        list.add(new int[]{preIdx, postIdx - 1});
      }
    }

```
above code logic missed one logical thing. when postIdx reached to len and even sum is bigger or smaller. preIdx should be reached to the len. for checking all cases.
so  "when the sum is bigger than input k. add the preIdx(for substract) and increase the idx" should be changed to
"otherwise the preIdx should be increased for checking all of the casese. when preIdx smaller than len"
below code is fixed code

``` java

 while (preIdx < len || postIdx < len) {
      if (postIdx < len && sum < k) {
        sum += sequence[postIdx++];
      } else if(preIdx < len) {
        sum -= sequence[preIdx++];
      }
      if (sum == k) {
        list.add(new int[]{preIdx, postIdx - 1});
      }
    }

```




> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
