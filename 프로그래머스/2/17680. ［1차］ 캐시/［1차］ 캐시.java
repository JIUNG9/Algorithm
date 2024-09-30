import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] c) {
        //cache에 cache사이즈 만큼 존재하지 않는다면 5을 소모하고 캐쉬에 인풋, 이때 이미 캐쉬가 존재한다면 +1
        //cache 사이즈만큼 캐쉬가 존재하는데 캐쉬가 존재하지 않는다면
        //가장 오래된 캐쉬를 꺼낸 다음 가장 fresh하게 저장(앞에 것을 poll한 이후 뒤에 push) 이후 + 5
        //cache 사이즈만큼 캐쉬가 존재하는데 해당 캐쉬가 존재하는 경우
        //해당 캐쉬를 꺼낸 다음 가장 fresh하게 뒷 부분에 푸쉬 +1
        //** 대소문자를 가리지 않는다.
        
        int answer = 0;
        
        
        
        
        for(int j = 0; j < c.length; j++){
            c[j] = c[j].toUpperCase();
        }
        
        
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < c.length; i++){

                if(list.contains(c[i])){
                    list.remove(c[i]);
                    list.add(c[i]);
                    answer+=1;
                }
                else{
                    list.add(c[i]);    
                    answer+=5;
                }
                while(list.size() > cacheSize){
                    list.pollFirst();
                }
            }
           
        
        return answer;
        
        
    }
}