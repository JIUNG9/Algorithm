import java.util.*;
class Solution {
    
    private boolean[ ] visited;
    private Set<Integer> set;
   /*
   numbers는 길이 1 이상 7 이하인 문자열입니다.
 -> 완전탐색, DFS
 
 
 visited, Set<Integer> (중복제거)
 011 -> Integer.parse로 해결 -> 11로 변환
 
 문제 접근: 숫자를 하나씩 concat하면서 만약 소수라면 정답을 하나씩 추가
 구현: 
 //맨 앞자리를 바꿔가면서 dfs를 호출
 for(int i = 0; i < len; i++){
 visited = new visited[length]; -> 새로운 visited arr 만들기
 visited[i] = true;
 dfs()
 }
 
 //dfs -> 방문하지 않았고 Set이 포함하지 않았고 해당 숫자가 프라임 넘버라면 ->Set에추가
 //Set에 추가 -> Integer.parseInt()
 //visited 방문 처리 
 // dfs(String.concat()) 을 사용
 
 //dfs 종료조건: iteration 중 len와 동일해진다면 break
 
 
   */
    public int solution(String s) {
        
        int len = s.length();
        set = new HashSet<>();
        

        visited = new boolean[len];
        dfs("",len, s,visited );
        
        return set.size();
    }
    
    
    public void dfs(String str, int len, String number, boolean[] visited) {
        
        
        if(!str.equals("") && isPrime(Integer.parseInt(str))){
            set.add(Integer.parseInt(str));
        }  
        
        for(int i =0; i < len; i++){
            if(str.length() < len && !visited[i]){
                visited[i] = true;
                dfs(str.concat(number.substring(i,i+1)), len, number, visited);
                visited[i] = false;
            }
            
        }
    
        
        
    }
        
            
    
    
    public boolean isPrime(int n){
        if(n==0) return false;
        if(n==1) return false;
        
        for(int i = 2; i < n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}