// import java.util.*;
// class Solution {
//     private String answer ="";
//     private List<String> list = new ArrayList<>();
//     private boolean[] visited;
//     public String[] solution(String[][] tickets) {
//         //만일 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return 합니다.
//         //출발지가 같은 여행지들은 알파벳 순서로 정렬하여, 해당 여행지를 먼저 갈 수 있도록한다.
//         //티켓을 한 번씩만 사용하여, 모든 곳을 방문하고, 해당 루트를 반환한다.(루트를 저장? -> String append하자," "로 띄우고)
//         //우선, 정렬 출발지로 정렬하고 이후, 출발지가 같다면 알파벳 오름차순 순서로 정렬, ICN로 스타트하여, 해당 출발지와 같은 것을 앞에서부터 찾는다, 그리고 찾으면 해당 문자열을 heap에 있는 문자열에 저장한다. 이를 모든 티켓을 다 방문할 때까지 한다. 그리고 나서 해당 문자열을 " "로 쪼개어 문자열을 만들어 반환하자
        
//         visited = new boolean[tickets.length];
//         Arrays.sort(tickets,(str1,str2)->{
//             if(str1[0].equals(str2[0])) return str1[1].compareTo(str2[1]);
//             return str1[0].compareTo(str2[0]);
//         });
        
//         dfs(tickets,"ICN");
//         for(int i = 0; i < list.size(); i++){
//             System.out.println("element: "+ list.get(i));
//         }
//         return answer.split(" ");
        
//     }
    
//     public void dfs(String[][] t, String target){
//    //정답 문자열에 해당 target을 붙여주고, 지속적으로 재귀가 실행될 때 해당 heap에 저장
//         answer= answer.concat(target);
//         for(int i = 0; i < t.length; i++){
//             //출발지가 타겟과 같다면 해당 지점을 방문, 또한 해당 티켓을 방문하지 않았어야함
//             //이렇게 되는 경우 ICN, AAA를 pop한 뒤 BBB가 오게 된다. 모든 도시를 방문하는 케이스만 추가하여, 해당 케이스만을 정답으로 반환.
//             if(t[i][0].equals(target)){        
//                 answer+=" ";
//                 dfs(t, t[i][1]);
//             }
//         }
        
//         list.add(answer);
//     }
// }



import java.util.ArrayList;
import java.util.Collections;
class Solution {
    static boolean[] visit;
    static ArrayList<String> list=new ArrayList<>();
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        DFS(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        String[] temp = list.get(0).split(" ");
        return temp;
    }

    private static void DFS(int cnt, String icn, String word, String[][] tickets) {
        if (cnt == tickets.length) {

            list.add(word);

        }else{
            for (int i = 0; i < tickets.length; i++) {
                if (!visit[i] && tickets[i][0].equals(icn)) {
                    visit[i]=true;
                    DFS(cnt+1,tickets[i][1],word+" "+tickets[i][1],tickets);
                    visit[i]=false;
                }
            }
        }
    }
}
