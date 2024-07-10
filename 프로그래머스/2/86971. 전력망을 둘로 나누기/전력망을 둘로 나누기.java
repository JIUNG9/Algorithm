import java.util.*;
import java.util.stream.*;
class Solution {
    
    private boolean[] visited;
    private List<int[]> list;
    private int connectedLen = 0;
    private int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        list = Arrays.stream(wires).collect(Collectors.toList());
        
        for(int i = 0; i < wires.length; i++){
            
            
            visited = new boolean[wires.length-1];
            int[] cutNode = wires[i];
            list.remove(cutNode);
            
            connectedLen = 1;
            visited[0] = true;
            

            dfs(list.get(0)[1],wires);
            dfs(list.get(0)[0],wires);
            
            answer = Math.min(Math.abs((connectedLen+1) - (n-(connectedLen+1))),answer);
            list.add(cutNode);
        }
        return answer;
        
        
    }
    public void dfs(int endNode, int[][] w){
        for(int i = 0 ; i < list.size(); i++){
            if(!visited[i] && endNode == list.get(i)[0]){
                connectedLen++;
                visited[i] = true;
                dfs(list.get(i)[1],w);
                visited[i] = false;
            }
            else if(!visited[i] && endNode == list.get(i)[1]){
                connectedLen++;
                visited[i] = true;
                dfs(list.get(i)[0],w);
                visited[i] = false;
            
            }
            
        }
    }
}