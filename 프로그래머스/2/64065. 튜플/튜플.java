import java.util.*;
import java.util.stream.*;
import java.util.regex.*;

class Solution {
    public int[] solution(String s) {

        //원소의 개수가 가장 적은 리스트를 순차적으로 정답에 담아 반환한다.
        
        //첫 문자와 마지막 문자를 제외하고 {.} 로 split 하여 각 배열을 얻는다. 그렇게 한다면 {}를 제외한 각 리스트의 원소들을 합한 문자열을 얻을 수 있다. 예시로는 {1,2,3}은 1,2,3이 된다. 해당 문자열을 ,로 스플릿하고 해당 문자열을 List<String[]>에 담는다. 해당 List에 있는 String 배열을 길이 기준으로 오름차순 정렬하여, List를 모두 순회하여 List의 0번째는 0번째 원소, 1번 째는 0번째에서 가지고 있지 않은 문자열, 
        int len = s.length();
        List<String[]> stringList = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
  
        s = s.substring(1,len-1);
            
        String[] removeBracketStr = s.split("[{}]");
        
        for(String str : removeBracketStr){
            if(str.equals("") || str.equals(",")) continue;
            String[] removedSeparator = str.split(",");
            for(String removedStr : removedSeparator){
            }
            stringList.add(removedSeparator);
        }
        
        stringList = stringList.stream().sorted((s1Arr,s2Arr)->{
            return s1Arr.length - s2Arr.length;
        }).collect(Collectors.toList());
        
        for(int i = 0; i < stringList.size();i++){
            String[] strArr = stringList.get(i);
            for(String strArrElement : strArr){
                int element = Integer.parseInt( strArrElement) ;
                if(!answerList.contains(element)) answerList.add(element); 
            }
        }
        return answerList.stream().mapToInt(i->i).toArray();
            
            
    }
}