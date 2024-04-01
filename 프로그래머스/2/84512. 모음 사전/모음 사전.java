class Solution {
    private int counter = 0;
    private int answer = 0;
    private String[] vowel = {"A","E","I","O","U"};
    public int solution(String word) {
        
        dfs(word, "",0);
        return answer;
    }
    public void dfs(String target, String current, int depth){
        
            if(target.equals(current)){
                answer = counter;
            }
        
        
            for(String v : vowel)
            {
                if(current.length() < 5){
                    counter++;
                    // System.out.println("current+vowel: "+ current+v);
                    dfs(target, current+v,depth+1);
                }

            }
        
}
}