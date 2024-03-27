import java.util.*;

class Solution {
    private int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        boolean[] visited = new boolean[words.length];
        dfs(words,visited, begin,target, 0);
        return answer== Integer.MAX_VALUE ? 0 : answer;
        
    }
    
    public void dfs(String[] w,boolean[] visited, String pat, String tar, int counter){
        // System.out.println("pat: "+ pat);
        if(tar.equals(pat)) {
            answer = Math.min(counter,answer);
        }
        for(int i = 0; i < w.length; i++){
            if(!visited[i] &&changedOnlyOneWord(pat,w[i])){
                visited[i] = true;
                dfs(w,visited, w[i], tar, counter+1);
                visited[i] = false;
            }
        }
    }
    
    
    public boolean changedOnlyOneWord(String input, String target){
        int counter = 0;
        for(int i = 0; i < input.length();i++){
            if(input.charAt(i) != target.charAt(i)) counter++;
        }
        return counter==1;
    }
}