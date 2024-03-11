# [level 3] 여행경로 - 43164 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43164) 



### Consideration

- The input size is under 10,000 -> can be solved with brute force
- Approach. should start from ICN
- '모든 도시를 방문할 수 없는 경우는 주어지지 않습니다.' -> should search all of that
- '만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.'
- 'alphabetical order' String sort.
-  solution : DFS


### Code

- initial input parameter should be "ICN" so the ICN will be first came in "current" String
- input the String as sequence with white space -> this will be also sorted by String::CompareTo(by alphabetical order) -> This meant the words at resultList will be started from the "ICN" and sorted by alphabetical order.


  


``` java
public String[] solution(String[][] t) {
    answerList = new ArrayList<>();
    boolean[] visited = new boolean[t.length];
    dfs(t, visited, "ICN");

    answerList.sort(String::compareTo);
    return answerList.get(0).split(" ");
  }


  public void dfs(String[][] t, boolean[] visited, String current) {
    for (int i = 0; i < t.length; i++) {
      String[] words = current.split(" ");
      if (words.length == t.length + 1) {
        if (words[0].equals("ICN")) {
          answerList.add(current);
        }
      } else {
        if (!visited[i] && words[words.length-1].equals(t[i][0])) {
          visited[i] = true;
          dfs(t, visited, current + " " + t[i][1]);
          visited[i] = false;
        }
      }
    }

  }
```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
