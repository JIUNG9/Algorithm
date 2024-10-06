import java.util.*;
class Solution {
    public int solution(String s, String[] st) {
       //Skill 트리의 모든 문자열을 순회하면서 Skill의 문자를 Skill트리가 가지고 있을 때 저장소에 저장한 후, 해당 Skill tree의 문자열을 탐색을 마쳤을 때, 해당 저장소에 있는 문자를 합쳤을 떄, skill을 각 문자열을 순차적으로 더했을 때 조합의 모든 경우의 수 중 하나라면  해당, 문자열은 올바른 것이다. 저장소에 문자가 존재하지 않는다면 해당 문자열은 스킬에 관계없이 배울 수 있으므로 가능한 스킬트리이다.
        int answer = 0;
        int len = st.length;
        List<String> criteria = new ArrayList<>();
        List<String> preList = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            if(i==0) criteria.add(s.substring(i,i+1));
            else{
               criteria.add(criteria.get(i-1) + s.substring(i,i+1));
            }
            preList.add(s.substring(i,i+1));
        }
        
        
        
        for(int i = 0; i < st.length; i++){
            List<String> list = new ArrayList<>();
            String currentSt = st[i];
            StringBuilder sb = new StringBuilder();
            //skill tree를 순회하면서 skill 문자열을 포함하고 있다면 해당 skill의 문자를 list에 추가 
            for(int j = 0; j < currentSt.length(); j++){
                if(preList.contains(currentSt.substring(j,j+1))){
                    list.add(currentSt.substring(j,j+1));
                }
            }
            
            for(int k = 0; k < list.size(); k++){
                sb.append(list.get(k));
            }
            
            
            if(criteria.contains(sb.toString()) || list.size() == 0){
                answer++;
            } 
            
        }
        
        
        return answer;
        
    }
}