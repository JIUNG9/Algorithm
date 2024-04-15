# [level 3] 여행경로 - 43164 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43164#) 

```
    public void dfs(boolean[] visited, int depth, int len, String dep, String words, String[][] t){
        if(len == depth){
          answerList.add(words.substring(1));
        } 
        
     
        for(int i =0; i < len; i++){
            if(!visited[i] && dep.equals(t[i][0])){
                visited[i] = true;
//dep = t[i][1]
//dfs(visited, depth+1, len, dep, words + " " + dep, t);
                dfs(visited, depth+1, len, t[i][1], words + " " + t[i][1], t);
                visited[i] =false;
            }
        
        }
        
    }
```
### The wrong one about quoted code
- There is the dep which is updated by destination. This is the problem. when the stack is pop() from the stack, The parameter which name has the statement. so when the inner block of if statment isn't satisfy the condition. The loop will be procceeded with the statement which is recently pop()


  
> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
