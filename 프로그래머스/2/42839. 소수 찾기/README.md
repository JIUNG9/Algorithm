# [level 2] 소수 찾기 - 42839 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42839) 

### Approach

- Logical : Check the every combination by the input which is not duplicated and then check the cases is the prime or not
- Implementation : Use the Set data structure for element is not duplicated, and use the stream() for concise the code. For more concise the code declare the method of isPrime for method reference and declare the as static method for not being used with not instantiated. For getting every case use the dfs which needs visited array as method parameter and add the cases after visited[i] = true
  

### Pesudo


``` java
Set<Integer> set
boolean[] visited
main(){
        set = new HashSet<>();
        boolean = new boolean[len];
        dfs(visited, String input, String curr);
        

}
dfs(boolean[] visited, String input, String curr){
        while(iterating all elements)
                If(!vistied[currentIdx])
                        visited[currIdx] = true;
                        set.add(curr+currCharacter);
                        dfs(visited, input, curr+currCharacter);
                        visited[currIdx] = false;
}



staic boolean isPrime(int num){
        
}
```

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
