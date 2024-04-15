import java.util.*;
class Solution {
    List<String> answerList;
    boolean[] visited;
    public String[] solution(String[][] t) {
        int len = t.length;
        String dep = "ICN";
        answerList = new ArrayList<>();
        visited = new boolean[len];
        dfs(visited, 0, len, dep, "", t);
        
        answerList.sort((s1,s2)->{
            return s1.compareTo(s2);
        });
        
        String answer = "ICN "+ answerList.get(0);
        return answer.split(" ");
            
        
        
    }
    
    
    public void dfs(boolean[] visited, int depth, int len, String dep, String words, String[][] t){
        //depth가 len과 일치할 때만 Heap 영역에 있는 리스트에 추가한다.
        if(len == depth){
          answerList.add(words.substring(1));
        } 
        
     
        for(int i =0; i < len; i++){
            if(!visited[i] && dep.equals(t[i][0])){
                visited[i] = true;
                dfs(visited, depth+1, len, t[i][1], words + " " + t[i][1], t);
                visited[i] =false;
            }
        
        }
        
    }
}