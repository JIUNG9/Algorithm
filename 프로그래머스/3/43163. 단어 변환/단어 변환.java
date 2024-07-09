
class Solution {
    private int answer = Integer.MAX_VALUE;
    private boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target,words, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
        
        
    }
    public void dfs(String current, String target, String[] words, int counter){
        for(int i = 0; i < words.length; i++){
            if(current.equals(target)){
                answer = Math.min(answer, counter);
            }
            else{
                if(!visited[i] && isOneCharacterDifferent(current,words[i])){
                    visited[i] = true;
                    dfs(words[i],target, words,counter+1);
                    visited[i] = false;
                }
            }
            
        }
        
    }
    public boolean isOneCharacterDifferent(String a, String b){
        int differentCounter = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) differentCounter++;
            if(differentCounter > 1) return false;
        }
        return true;
    }
    
}