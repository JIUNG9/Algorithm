# [level 2] 튜플 - 64065 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/64065) 

### Approach
- Logic: Return the array which is colelcted by the List, which has the String[] as the Type. The List is sorted by ASC from the length of the String[]. and the Returned Array should be added which isn't added before
- Impl: For using the split method from the String, remove the first character, and last character which is the bracket,
  and split the string by {}, But can't use the directly {} it is the qualifier at the Regex. So spearte by [{}] . and there will be String which contains also white space at first and ','. so when iterating the element and meet two of String just continue. otherwise add the List. and then sort by the length of array by AESC order. at last iterating this List. When there isn't the element at the answerList, add the element and answer.


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
