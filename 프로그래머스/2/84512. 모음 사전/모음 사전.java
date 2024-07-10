class Solution {
    private String[] vowel ={"A","E","I","O","U"};
    private int counter = 0;
    private int answer = 0;
    
    public int solution(String word) {
        dfs("",word);
        return answer;
    }
    public void dfs(String current, String target){
        if(current.equals(target)) {
            answer = counter;
        }
        if(current.length() >= 5) return;
        else{
            for(String s: vowel){
                counter++;
                dfs(current+s, target);
            }
        }
        
        
    }
}