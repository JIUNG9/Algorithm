import java.util.*;
class Solution {
    
    private Map<String,String> map;
    private List<String> list;
    
    public String[] solution(String[] record) {
        map = new HashMap<>();
        list = new ArrayList<>();
        String[][] str = new String[record.length][3];
        int idx = 0;
        //split by " "
        for(String s: record){
            str[idx++] = s.split(" ");    
        }
        
        
        //iterate for getting final nickname
        
        for(String[] sArr : str){
            String type = sArr[0];
            if(type.equals("Enter") || type.equals("Change")){
                map.put(sArr[1], sArr[2]);    
            }
        }
        
        
        //get answer (when str[0] == enter || str[0] == leave)
        for(String[] sArr : str){
            String type = sArr[0];
            String nickname = map.get(sArr[1]);
            if(type.equals("Enter")){
                list.add(getGreetingMessage(nickname));
            }
            if(type.equals("Leave")){
    
                list.add(getLeaveMessage(nickname));    
            }
    }
        
        return list.toArray(String[]::new);
    }
    
    public String getGreetingMessage(String nickname){
        return nickname + "님이 들어왔습니다.";
    }
    public String getLeaveMessage(String nickname){
        return nickname + "님이 나갔습니다.";
    }
}