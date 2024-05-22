# [level 2] 소수 찾기 - 42839 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42839) 


### Approach


### Missed point

``` java

Compare two of dfs. The difference is input the String which is concated String and another one is concat the String as the input parameter. when the stack is pop. The first one String is still concated otherwise another one is not. This can be built by programmer intention. but handling this approach use the second one

main(){
dfs("",arr,arr.length);
}

 public void dfs(String pat,String[] arr, int len){
        for(int i = 0; i < arr.length; i++){
                if(pat.length() < len && !used[i]){
                    pat = pat.concat(arr[i]);
                    Integer patNum = Integer.parseInt(pat);
                        if(isPrime(patNum)) set.add(patNum);
                            used[i] = true;
                            dfs(pat, arr,len);
                            used[i] = false;
            }
        }   
    }
```

``` java

main(){
dfs("",arr,arr.length);
}

public void dfs(String pat,String numbers){
        if(!pat.equals("") && isPrime(Integer.parseInt(pat))) set.add(Integer.parseInt(pat));
        
                for(int i = 0; i < numbers.length(); i++){
                    if(pat.length() < numbers.length() && !used[i]){
                            used[i] = true;
                            dfs(pat + numbers.substring(i,i+1),numbers);
                            used[i] = false;
            }
        }
    }


```




> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
