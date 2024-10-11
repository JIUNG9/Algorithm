import java.util.*;
import java.util.stream.*;
class Solution {
    public String[] solution(String[] record) {
        
        //최종적으로 업데이트 된 이름으로 순차적으로 greeting 메시지와 exit message가 출력돼야한다. Change 메시지는 출력하지 않는다. Change일 경우 닉네임만 수정한다. 나가는 경우는 
        //HashMap (아이디, 닉네임) // 순서 -> Queue(명령어, id)
        //닉네임만 수정된다는 것은 map의 값만을 수정하면 된다는 것, 메시지 출력x 
        Queue<String[]> q = new LinkedList<>(); 
        Map<String, String> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < record.length; i++){
            String[] arr = record[i].split(" ");
            String command = "";
            String id = "";
            String nickname = "";
            
            if(arr.length < 3){
                 command = arr[0];    
                 id = arr[1];
            }
            
            else{
                 command = arr[0];  
                 id = arr[1];
                 nickname = arr[2];    
            }
                        
            if(!nickname.equals("")) map.put(id, nickname);
            if(!command.equals("Change")) q.add(new String[]{command, id});

        }
        
        while(!q.isEmpty()){
            String[] arr = q.poll();
            String command = arr[0];
            String id = arr[1];
            answer.add(getMessage(map.get(id),command.substring(0,1)));
        }
        return answer.stream().toArray(String[]::new);
        
        
    }
    
    public String getMessage(String name, String command){
        if(command.equals("E")){
            return name +"님이 들어왔습니다.";
        
        }
        else if(command.equals("L")){
            return name + "님이 나갔습니다.";
        }
        return "";
    
    }
        
}