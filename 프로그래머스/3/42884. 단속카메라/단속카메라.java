import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        //차량의 끝지점에는 적어도 한 개의 카메라가 존재해야한다.
        //시작지점을 기준으로 오름차순으로 정렬하였을 때 끝나는 차량의 끝 지점에 다른 차량이 이미 지나가거나 해당 지점에 있다면 끝지점에 한 대만 설치하여도 해당 끝지점보다 작은 지점에서 출발하는 차량까지 모두 카메라에 찍힌다. 이떄 함께 찍을 수 있는 차량이 존재할 때까지 해당 차량들을 찾고, 만약 이후에 출발하는 차량의 지점이 더 크다면 카메라를 한 대 설치하고 출발하는 차량의 더 큰 지점으로 이동하여 해당 지점부터 다시 카메라를 설치하여 확인한다.
        int len = routes.length;
        int idx = 0;
        int position = 0;
        int counter = 0;
        Arrays.sort(routes,(arr1,arr2)->{
            return Integer.compare(arr1[1],arr2[1]);
        });
        while(position < len){
            if(idx < len && routes[position][1] >= routes[idx][0]){
                idx++;
                
            }        
            else{
                position = idx;
                counter++;
            }
        }
        
        return counter;
    }
}