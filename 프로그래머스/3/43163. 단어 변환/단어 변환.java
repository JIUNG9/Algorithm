import java.util.*;
class Solution {
    private boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        //begin 문자열부터 시작해서 하나만 다른 문자열을 고르고 이미 사용한 것이 아니라면 현재 진행한 반복수와 해당 문자열을 저장소에 저장한다. 이후 저장소에 저장된 것을 순차적으로 저장된 순서대로 하나씩 뽑아 가장 먼저 target이 된 것의 반복된 횟수를 반환하고, 만약 찾지 못 한다면 0을 반환한다. 
        int len = words.length;
        visited = new boolean[len];
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(0,begin));
        
        while(!q.isEmpty()){
            Word word = q.poll();
            String currWord = word.w;
            int counter = word.c;
            
            if(currWord.equals(target)) return counter;
            
            for(int i = 0; i < len; i++){
                if(!visited[i]){
                    if(isOnlyOneCharacterDiff(currWord,words[i])){
                        visited[i] = true;    
                        q.add(new Word(counter+1, words[i]));
                    }
                }
            }
            
        }
        return 0;
        
        
    }
    
    public boolean isOnlyOneCharacterDiff(String curr, String target){
        int counter = 0;
        for(int i = 0; i < curr.length(); i++){
            if(curr.charAt(i) != target.charAt(i)) counter++;
        }
        return counter > 1 ?  false : true;
    }
    
    
    class Word{
        private int c;
        private String w;
        public Word(int c, String w){
            this.c = c;
            this.w = w;
        }
    }

}