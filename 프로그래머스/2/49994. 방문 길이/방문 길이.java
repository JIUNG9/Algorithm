import java.util.*;
class Solution {
    private Map<String, int[]> map;
    private int answer = 0;
    public int solution(String dirs) {
        
        //사용자가 5 * 5을 지시 방향대로 움직이는데, 움직이는 곳이 맵을 초과한다면 아무 행동도 하지 않고, 만약 초과하지 않았다면 해당 위치로 움직이고 이미 방문한 적이 없는 위치라면 해당 위치를 기록한다. 처음 방문하는 길의 루트 (from + to), (to + from이 같은 것으로 작용한다.)
        //Feed -> 문제 좀 더 꼼꼼히 보기. 테스트 케이스를 좀 더 잘 살펴보면 됐었다.
        int currentX = 0;
        int currentY = 0;
        Set<String> set = new HashSet<>();
        map = new HashMap<>();
        initMap();
        
        for(int i = 0; i < dirs.length(); i++){
            String s = String.valueOf(dirs.charAt(i));
            int[] d = map.get(s);
            int movedX = currentX +  d[1];
            int movedY = currentY +  d[0];
            if(!isMapExceeded(movedY,movedX)){
                String from = String.valueOf(currentY) + String.valueOf(currentX);
                String to = String.valueOf(movedY) + String.valueOf(movedX);
                if(!set.contains(from+to) && !set.contains(to+from)){
                    set.add(from+to);    
                    set.add(to+from);
                    answer++;
                }
                currentX = movedX;
                currentY = movedY;
            }
        }
        return answer;
        
        
    }
    public void initMap(){
        map.put("U", new int[]{1,0});
        map.put("L", new int[]{0,-1});
        map.put("R", new int[]{0,1});
        map.put("D", new int[]{-1,0});
    }
    
    public boolean isMapExceeded(int y, int x){
        if(y < -5 || x < -5 || y > 5 || x > 5) return true;
        return false;
    }
}