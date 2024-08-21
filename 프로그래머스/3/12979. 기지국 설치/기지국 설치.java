// class Solution {
//     private int answer = 0;
//     public int solution(int n, int[] stations, int w) {
//       //station이 존재하고 시작 범위(1)부터 기지국이 가지는 범위를 더하여 가장 앞에 위치하는 기지국이 커버하는 범위(stations[idx] - w) 보다  작을 경우 기지국을 설치하지 않고 존재하는 기지국위치에 기지국이 다룰 수 있는 최대 범위(기지국 + w) 이동하여 해당 위치부터 검색한다.
//     //station이 존재하고, 가장 앞에 존재하는 기지국이 커버할 수 없다면  기지국을 설치하고 현재 위치에서 기지국이 다루는 범위 * 2 + 1 위치로 이동하여 확인한다.(*2까지는 커버가 가능하므로)
//         //station이 아예 존재하지 않는 경우는 기지국이 좌우로 커버가 가능한 범위만큼 이동하여 해당 위치에서 끝까지 전부 기지국을 설치한다.
//         int stationIdx = 0;
        
//         for(int position = 1; position < n;){
//             if(stationIdx < stations.length){
//                  if(position >= stations[stationIdx] - w -1){
//                     position=stations[stationIdx] + w + 1;
//                     stationIdx++;
//                 }       
//                  else{
//                     answer++;
//                     position+= (w + 1);
//                 }
//             }
//             else{
//                 answer++;
//                 position+=2*w+1;
//             }        
//     }
//                     return answer;

// }
// }
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIdx = 0;
        int position = 1;
        
        while (position <= n) {
            if (stationIdx < stations.length && position >= stations[stationIdx] - w) {
                position = stations[stationIdx] + w + 1;
                stationIdx++;
            } else {
                answer++;
                position += (2 * w) + 1;
            }
        }
        
        return answer;
    }
}
