import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        //{number, number}-> {} 안에 있는 한 개 혹은 여러 개의 숫자람녀 숫자와 , 조합을 그룹하여 얻어야함
        //1개, 2개, 3개 .. n개까지가 있는 원소들을 얻고, 개수별로 오름차순하여 정렬한 것에 1개 부터 존재하지 않는 것만 결과값에 집어넣고 해당 결과를 반환한다.
        Pattern pattern = Pattern.compile("\\{([0-9,]+)\\}");
        Matcher matcher = pattern.matcher(s);
        List<String> answerList = new ArrayList<>();
        List<String[]> list = new ArrayList<>();
        while(matcher.find()){
            String str = matcher.group(1);
            String[] arr = str.split(",");
            list.add(arr);
        }
        list = list.stream().sorted((list1,list2) -> {
            return Integer.compare(list1.length, list2.length);
        }).collect(Collectors.toList());
        
        for(String[] arrStr : list){
            for(int i = 0; i < arrStr.length; i++){
                
                if(!answerList.contains(arrStr[i])){
                  answerList.add(arrStr[i]);
                } 
            }
        }
        return answerList.stream().mapToInt(i->Integer.parseInt(i)).toArray();
       
    }
}
