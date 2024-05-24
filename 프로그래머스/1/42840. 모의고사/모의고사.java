import java.util.*;
import java.util.stream.*;
class Solution {
 
    
    private int[] firstMan = {1,2,3,4,5};
    private int[] secondMan = {2,1,2,3,2,4,2,5};
    private int[] thirdMan = {3,3,1,1,2,2,4,4,5,5};
    private List<Integer> answerList;
    int firstManCounter = 0;
    int secondManCounter = 0;
    int thirdManCounter = 0;
    public int[] solution(int[] answers) {
        
        int firstManLen = firstMan.length;
        int secondManLen = secondMan.length;
        int thirdManLen = thirdMan.length;
        answerList = new ArrayList<>();
        
        for(int i = 0; i < answers.length; i++){
            int answer = answers[i];
            if(answer == firstMan[i%firstManLen]) firstManCounter++;
            if(answer == secondMan[i%secondManLen]) secondManCounter++;
            if(answer == thirdMan[i%thirdManLen]) thirdManCounter++;
        }
        
        List<List<Integer>> counterList = List.of(List.of(1,firstManCounter),List.of(2,secondManCounter),List.of(3,thirdManCounter));
                
        counterList = counterList.stream().sorted((list1,list2)->{
            int answer = Integer.compare(list2.get(1),list1.get(1));
            if(answer == 0) return Integer.compare(list1.get(0),list2.get(0));
            return answer;
        }).collect(Collectors.toList());
        
        int maxValue = counterList.get(0).get(1);
        for(List<Integer> list : counterList){
            int value = list.get(1);
            int manIdx = list.get(0);
            if(value==maxValue) answerList.add(manIdx);
        }
        
        return answerList.stream().mapToInt(i->i).toArray();
        
        
        
        
        
        
    }
}