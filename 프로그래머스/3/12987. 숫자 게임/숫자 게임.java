import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        //가장 작은 차이로 상대를 이겨야하고, 가장 큰 차이로 상대와의 경기에서 진다면 이것이 최적의 해이다.
        //각 배열을 오름차순하고, B가 A를 이길 수 있을 때까지 B의 포인터를 움직이면서 A와의 경기를 한다.이후 B와 A가 경기를 치룰 떄 B의 값이 더 크다면 A의 포인터 또한 움직이고 B의 포인터가 끝까지 다달았을 때, A의 포인터가 다 달았을 때 게임은 종료된다.
        int answer = 0;
        int aIdx = 0;
        int bIdx = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        while(aIdx < A.length && bIdx < B.length){
            while(bIdx < B.length && B[bIdx] <= A[aIdx]){
                bIdx++;
            }
            if(bIdx < B.length && B[bIdx] > A[aIdx]){
                bIdx++;
                aIdx++;
                answer++;
            }
        }
        return answer;
    }
}