import java.util.*;
class Solution {
    private boolean[] visited;
    private Set<Integer> set;
    public int solution(String numbers) {
        //주어진 numbers를 한 번씩 사용하여 만들 수 있는 모든 숫자의 경우를 구하여 구한 것들 중, 만약 소수라면 해당 숫자를 정답에 추가한다. 
        String[] arr = numbers.split("");
        set = new HashSet<>();
        int len = arr.length;
        visited = new boolean[len];
        dfs("",arr);
        return theNumberOfPrime(set);
        
        
    }
    public int theNumberOfPrime(Set<Integer> set){
        int answer =0; 
        for(Integer i : set)
        {
            boolean flag = true;
            if(i == 2) {
                answer++; continue;
            }
            if(i == 0 || i == 1) continue;
            if(i % 2 == 0) continue;
            
            for(int j = 3; j <= Math.sqrt(i); j+=2){
                
                if(i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }        
        return answer;
        
    }
    public void dfs(String curr, String[] arr){
        if(!curr.equals("")) set.add(Integer.parseInt(curr));
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(curr+arr[i], arr);                
                visited[i] = false;
            }
        }
    }
}