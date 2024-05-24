class Solution {
    private int answer = 0;
    private int counter = 0;
    private String[] vowels = {"A","E","I","O","U"};
    
    public int solution(String word) {
        
        dfs("",word);
        return answer;
    }
    public void dfs(String currentStr, String target){
        if(target.equals(currentStr)) answer = counter;
        for(String currentVowel : vowels){
            if(currentStr.length() < 5 ){
                counter++;
                dfs(currentStr + currentVowel, target);
            }
            
        }
            
        }
        
    }
