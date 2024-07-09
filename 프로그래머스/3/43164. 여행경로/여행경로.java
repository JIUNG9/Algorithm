import java.util.*;
import java.util.stream.*;

class Solution {
    private List<String> answerList;
    private boolean[] visited;
    
    public String[] solution(String[][] t) {
        int len = t.length;
        answerList = new ArrayList<>();
        visited = new boolean[len];
    
        dfs("ICN","ICN",0,t);
        
        return answerList.stream().sorted().collect(Collectors.toList()).get(0).split(",");
        
        
        
        
    }
    
    public void dfs(String route,String recent, int depth, String[][] t){
        if(depth == t.length){
            answerList.add(route);
        }
        else{
            for(int i = 0; i < t.length; i++){
                if(!visited[i] && recent.equals(t[i][0])){
                    visited[i] = true;
                    dfs(route+","+t[i][1],t[i][1],depth+1,t);
                    visited[i] = false;
                }
            }
        }
    
    
    }
}
