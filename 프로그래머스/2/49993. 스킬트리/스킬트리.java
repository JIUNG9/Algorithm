import java.util.*;
import java.lang.*;
class Solution {
    List<String> possilbleList;
    
    public String[] getPreReqStringArr(String skill){
        return skill.split("");
    }
    
    public boolean isContain(String[] preReq, char c){
        for(String s: preReq){
            if(s.charAt(0) == c) return true;
        }
        return false;
    }
    public void createPossibleList(String skill){
        possilbleList = new ArrayList<>();
        possilbleList.add("");
        for(int i = 1; i < skill.length()+1; i++){
            possilbleList.add(skill.substring(0,i));
            }
        }
    
    
    
    
    
    public int solution(String skill, String[] s) {
        int counter =0;
        String[] preReq = getPreReqStringArr(skill);
        createPossibleList(skill);
        for(int i =0; i < s.length; i++){
            Stack<Character> stk = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < s[i].length(); j++){
                char c = s[i].charAt(j);
                if(isContain(preReq,c)){
                    stk.push(c);
                }
            }
                while(!stk.isEmpty()){
                    sb.append(String.valueOf(stk.pop()));
                }
                    String ordered = sb.reverse().toString();
                    // System.out.println("ordered: "+ ordered);
                        if(possilbleList.contains(ordered)){
                              counter++;      
                        } 
                    
        
        }
        
        
        return counter;
    }
}