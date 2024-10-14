class Solution {
    public int solution(int n, int[] stations, int w) {
    //마지막에 세운 기지국이 모든 아파트들을 커버할 수 있을 때까지, 기지국을 세운다. 현재 위치를 먼저 세워놓은 기지국이 전파 거리가 닿아 커버가 가능하다면 현재 위치에 세우지 않고, 먼저 세워놓은 기지국이 전파 거리가 닿지 않은 거리까지 이동하고, 이후 반복적으로 먼저 세워 놓은 기지국이 존재한다면 확인하면서 이동한다. 만약 기지국이 더 이상 존재하지 않는다면 지속적으로 기지국을 세우면서 이동한다. 이때 기지국을 추가적으로 세운 개수를 반환하라.
        int idx = 1;
        int answer = 0;
        int stationIdx = 0;
        int stationLen = stations.length;
        while(idx <= n){
            if(stationIdx < stationLen){
                //커버가 가능하다면 다음 기지국을 확인하는 걸로 수정하고, 위치를 기지국이 커버 가능한 다음 위치까지
                if(stations[stationIdx] - w <= idx ){
                     idx = (stations[stationIdx] + w + 1);
                    stationIdx++;
                }
                else{
                    idx+=(2*w+1);
                    answer++;
                }
            }
            else{
                 idx+=(2*w+1);
                 answer++;
            }
            // System.out.println("idx: "+ idx);
            // System.out.println("answer: "+ answer);
            
        }
        
        return answer;


    }
}