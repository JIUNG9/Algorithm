import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int camera = 0;
        Arrays.sort(routes, (arr1, arr2) -> Integer.compare(arr1[1], arr2[1]));

        
        int start = 0;
        int rear = 0;
        int len = routes.length;
    
        
        while(start < len){
            while(rear < len && routes[start][1] >= routes[rear][0]){
                rear++;
            }
                camera++;
                start = rear;
        }
        return camera;
        
    }
      
}