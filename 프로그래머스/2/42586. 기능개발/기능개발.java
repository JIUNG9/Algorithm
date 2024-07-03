import java.util.*;

class Solution {
    List<Integer> answerList;
    List<Stack<Integer>> stkList;
    public int[] solution(int[] p, int[] s) {
        
        stkList = new ArrayList<>();
        answerList = new ArrayList<>();
        
        init(p,s);
        
        while(!stkList.isEmpty()){
            proceedTheDay();
            int counter = todayDeployCouter();
            if(counter !=0) answerList.add(counter);
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
        
        
    }
    public void init(int[] p, int[] s){         
        for(int i = 0; i < p.length; i++){
            Stack<Integer> stk = new Stack<>();    
            int currentProgress = p[i];
            int currentSpeed = s[i];
            while(currentProgress < 100){
                stk.push(currentProgress);
                currentProgress += currentSpeed;
            }
            stkList.add(stk);
        }
    }
    public void proceedTheDay(){
        for(Stack<Integer> stk : stkList){
            if(!stk.isEmpty()) stk.pop();
            
        }
    }
    public int todayDeployCouter(){
        int counter = 0;
        
        while(stkList.size() > 0 && stkList.get(0).isEmpty()){
            counter++;
            stkList.remove(0);
        }
        
        return counter;

        
        }
    
}