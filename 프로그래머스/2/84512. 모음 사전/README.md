# [level 2] 모음 사전 - 84512 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/84512) 

### Approach
- Use the dfs because the input size is under the 5.

The original approach

```
    public void dfs(String target, String curr,  String[] arr){
        for(int i = 0; i < arr.length; i++){
            if(target.equals(curr)){
                answer = counter;
            }
            if(curr.length() < arr.length){
                counter++;
                dfs(target,curr+arr[i],arr);
            }
        }
    }

```

#### Problem 
- The method is the pop from the stack and then iterated by the loop the answer would be renewed
- Let's say the Current is the AAAE and do dfs when second if statement condition is satisfied. there will be checked the number of arr.length times. so answer value will be updated.(THIS IS THE PROBLEM)


 ``` 
    public void dfs(String target, String curr,  String[] arr){
        for(int i = 0; i < arr.length; i++){
            if(target.equals(curr+arr[i])){
                answer = counter+1;
            }
            if(curr.length() < arr.length){
                counter++;
                dfs(target,curr+arr[i],arr);
            }
        }
    }

```

#### Solution
- The above code check when concated String is mathced with the target. but add the counter + 1 also(because this is not yet considered pushed into the stack)



> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
