# [level 2] 2 x n 타일링 - 12900 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12900) 

## Consideration

### Combination(Stack over flow)
``` java

    /** Using combination with factorial it will be occurred stack over flow. ex) 16! already over the int range
     * as alternative. can use the Dynamic Programming. because there is the rule. so by increasing
     * index value increase the answer by following the rule *
     * The below code is built with Combination approach/

public int solution(int n){  
  int answer = 0;
  for(int i = 1; i <= n/2; i++){
    answer+= getCombination(i,n-(2*i));
  }
  return answer + 1;//add the case all of consisted by 1
}



public long getCombination(int theNumberOf2,int theNumberOf1){
  int total = theNumberOf1 + theNumberOf2;
  long totalFact = factorial(total);
  long theNumberOf1Fact = factorial(theNumberOf1);
  long theNumberOf2Fact = factorial(theNumberOf2);

  return totalFact / (theNumberOf1Fact * theNumberOf2Fact);

}

public long factorial(int n){
  long answer = 1;
  for(int i = n; i > 0; i--){
    answer*=i % 1000000007;
  }
  return answer;
}

```
### Alternative (DP)
``` java
 public int solution(int n){
    /**
     * save the remainder value in advance for preventing input value range being stack over flow. (distribution law)
     * 
     */

    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;

    for(int i = 2; i < n; i++){
      dp[i] = (dp[i-2] + dp[i-1]) % 1000000007;
    return dp[n-1];
    }
}

```



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
