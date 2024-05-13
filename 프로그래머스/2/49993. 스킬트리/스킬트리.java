import java.util.*;
import java.util.stream.*;

class Solution {
    
    private List<String> answerList;
    
    
   private void initAnswerList(String skill){
       int len = skill.length();
       String str = "";
       answerList.add(str);
       for(int i = 0; i < len; i++){
          String current = String.valueOf(skill.charAt(i));
          str = str.concat(current);
           // System.out.println("str: "+ str);
           answerList.add(str);
       }
       
       
    }
    
    public int solution(String skill, String[] st) {
        int answer = 0;
        answerList = new ArrayList<>();
        initAnswerList(skill);
        String[] skills = skill.split("");
        
        List<String> skillList = Arrays.stream(skills).map(s->s).collect(Collectors.toList());
        
        
        for(int i = 0; i < st.length; i++){
            Queue<String> q = new LinkedList<>();
            String current = st[i];
            String result="";
            for(int j = 0; j < st[i].length(); j++){
                char currentChar = current.charAt(j);
                String currentStr = String.valueOf(currentChar);
                if(skillList.contains(currentStr)){
                    q.add(currentStr);
                }
                    
                }
            while(!q.isEmpty()){
                result = result.concat(q.poll());
            }
            
            if(answerList.contains(result)) {
                answer++;
            }
            }
                return answer;

        }
    }
