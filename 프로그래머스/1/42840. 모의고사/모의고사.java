import java.util.*;
import java.util.Map.*;
class Solution {
    
        int[] a = { 1,2,3,4,5};
        int[] b = { 2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
    //input size 10,000 => n^2 can be ol
    //문제의 정답 1,2,3,4,5
    //가장 높은 점수를 받은 사람 여럿일 경우 -> 오름 차순
    //한 명일 경우 하나
    public int[] solution(int[] answer) {
        
        //pseudo code
        /*
        1번 2번 3번 규칙을 구한다.
        int[] a = { 1,2,3,4,5};
        int[] b = { 2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        answer을 순회하면서
        Map에 해당 인덱스와 카운터를 추가한다.
        a가 맞췄으면 map.put(1, map.getOrDefault(1,0)+1)
        b가 맞췄으면 map.put(2, map.getOrDefault(2,0)+1)
        c가 맞췄으면 map.put(3, map.getOrDefault(3,0)+1)
        
        answer을 순회 이후
        해당 리스트를 answer[]의 value를 기준으로 내림차순 정렬한다.
        정렬 이후 가장 첫 번째의 키를 정답리스트에 추가한다.
        첫 번째의 키와 같은 value를 저장하고 해당 value와 같다면 같은 것들을 순회하여 answerList에 추가한 후 오름 차순으로 정렬하고 배열로 반환하여 정답을 얻는다.
    
        
        */
        
      Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < answer.length; i++) {
      int firstMan = a[i % 5];
      int secondMan = b[i % 8];
      int thirdMan = c[i % 10];
      if (firstMan == answer[i]) {
        map.put(1, map.getOrDefault(1, 0) + 1);
      }
      if (secondMan == answer[i]) {
        map.put(2, map.getOrDefault(2, 0) + 1);
      }
      if (thirdMan == answer[i]) {
        map.put(3, map.getOrDefault(3, 0) + 1);
      }
    }
        

    Set<Entry<Integer, Integer>> set = map.entrySet();
    List<Entry<Integer, Integer>> list = new ArrayList<>(set);
    List<Integer> answerList = new ArrayList<>();    
        
        list.sort((o1,o2)->{
          return Integer.compare(o2.getValue(),o1.getValue());
        });
        
        if(list.size() == 0) return new int[]{1,2,3};
        
        else{
            int maxValue = list.get(0).getValue();
            answerList.add(list.get(0).getKey());
            for(int i =1; i < list.size(); i++){
                if(list.get(i).getValue() == maxValue) answerList.add(list.get(i).getKey());
            }
        
            return answerList.stream().sorted().mapToInt(Integer::intValue).toArray();
        }
        

        

}
}