import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        
        //10^7^2를 통해 모든 정사각형의 case를 구하는 것은 시간 초과가 나므로, 시작 row부터 끝 row까지 원소를 구한 뒤 원하는 원소만 출력
        //Impl: 시작row는 left에서 n을 나눈 것 부터 시작, 끝row는 나눈 것에서 + 1
        //row를 모은 이후 시작점은 left % n, end row쪽은 right보다 더 많은 원소를 담았으므로 담은 원소들의 길이에서 right를 뺀 것의 길이만큼 제외하고 
        //left부터 right를 담는다.
        //0번째 row이면 1이 1개 이고 n까지, 1번째 row이면 2가 2개이고 n까지, 2번째 row이면 3이 3개이고 n까지
        //row의 크기가 증가할 때 마다 넣어야하는 반복 수와 숫자가 같다, 이후 끝난 숫자부터 n까지 연속적인 숫자를 입력
        int startRow = (int)(left/n);
        int endRow = (int)(right/n);
        int totalLen = ((endRow - startRow) * n);
        int startIdx = (int)(left % n);
        int endIdx = startIdx +(int)(right - left);
        List<Integer> list = new ArrayList<>();
        
        for(int i = startRow; i <= endRow; i++){
            for(int j = 0; j < i+1; j++){
                list.add(i+1);        
            }
            for(int k = i + 2; k <= n; k++){
                list.add(k);
            }
        }
        return list.subList(startIdx,endIdx+1).stream().mapToInt(i->i).toArray();
        
    }
}