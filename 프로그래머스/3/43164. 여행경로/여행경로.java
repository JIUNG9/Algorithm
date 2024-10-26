import java.util.*;
import java.util.stream.*;
class Solution {
    private String answer ="";
    private boolean[] visited;
    public String[] solution(String[][] tickets) {
        //ICN 출발
        //10000개 이하
        //주어진 항공권 모두 사용
        //출발지가 같은 경우 앞에있는 경로
        //모든 도시를 방문해야한다.
      
        //모든 도시를 방문했을 때, 출발지가 같다면 도착지가 알파벳으로 오름차순된 것의 순서부터 도착지로 설정하여, 출발지부터 이후에 도착한 것들의 도시를 붙여 정답을 반환한다.
        //한 번 방문한 티켓은 더 이상 사용하지 못 하고, 모든 케이스를 확인하여 모든 도시를 방문했을 때, 해당 케이스를 정답으로 반환한다. 
        //구현 방법: DFS를 활용하여,해당 String에 문자열을 concat하여, 해당 문자열을 반환하려는 생각이었으나, 그렇게 된다면 최정적으로 반환하는 것이 정답이됨, 따라서 이를 해결하기 위해서는 문자열을 출발지가 같다면 오름차순이아닌 내림차순으로 정렬했을 때, 해당 값이 정답이 된다.
        // 해당 문제는 DFS이고 조합을 사용해야하므로 visited와 for loop를 활용한다. 
        // 그리고 진행 시, stack에 들어갈 것은 스택에 따라서 변화하는 문자열 또한 포함한다.
        Arrays.sort(tickets,(str1,str2)->{
            if(str1[0].equals(str2[0]))  return str2[1].compareTo(str1[1]);
            return str1[0].compareTo(str2[0]);
        });
        
        
        int len = tickets.length;
        visited = new boolean[len];
        dfs(0,"ICN","ICN",tickets);
        return answer.split(" ");
    }
    
    public void dfs(int depth, String curr, String dest, String[][] t){
        if(depth == t.length){
            answer = curr;
        }
        else{
            for(int i = 0; i < t.length; i++){
                if(!visited[i] && t[i][0].equals(dest)){
                    visited[i] = true;
                    dfs(depth+1, curr + " " + t[i][1], t[i][1], t);
                    visited[i] = false;
                }
            }
        }
    }
}