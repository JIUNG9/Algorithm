import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        //1번부터 n까지의 사람들이 2글자 이상 앞 사람이 말한 끝 글자를 이어서 끝말잇기를 진행한다. <한 번 사용된 단어는 사용될 수 없고> 만약 탈락된다면 탈락된 차례, 현재까지 반복된 차례와 그 사람의 번호 수를 반환한다.
        int turn = 1;
        int currentPersonNumber = 1;
        Set<String> set = new HashSet<>();
        char lastWord = ' ';
        for(int i = 0; i < words.length; i++){
            if(i == 0) {
                lastWord = words[i].charAt(words[i].length()-1);
                set.add(words[i]);
                continue;
            }
            else{
                //현재 사람 넘버를 업데이트 (i % n) + 1 연산을 통해 사람의 넘버를 업데이트
                //사람은 1번부터 시작하지만 words는 0부터 시작하므로
                currentPersonNumber = i % n  + 1;
                //n명의 사람이 모두 자신의 차례를 지난다면 -> % n이 0이 된다면 해당 턴을 증가
                if(i % n == 0) turn++;
                
                 //이미 말 하거나 글자가 다르면 위에서 업데이트한 차례와 현재 자신의 숫자를 반환
                if(lastWord != words[i].charAt(0) || set.contains(words[i])){
                    return new int[]{currentPersonNumber, turn};
                }
                
                
                //현재 말 하는 사람의 첫 글자와 이전 사람이 말한 lastWord가 같은지 확인
                else {
                    //같다면 lastWord를 업데이트
                    //이미 말한 목록에 추가
                    lastWord = words[i].charAt(words[i].length()-1);
                    set.add(words[i]);
                    
                }
            }
            
        }
        return new int[]{0,0};
    }
}