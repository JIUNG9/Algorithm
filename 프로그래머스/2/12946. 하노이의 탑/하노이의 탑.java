import java.util.*; 
import java.util.stream.*; 

class Solution {
    List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        dfs(n, 1,3,2);
        int[][] answer = new int[list.size()][2];
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
        
        
    }
    public void dfs(int n, int start, int to, int mid){
        if(n == 1){
            list.add(new int[]{start,to});
        }
        else{
            dfs(n-1, start, mid, to);
            list.add(new int[]{start, to});
            dfs(n-1, mid, to, start);
        }
    }
}