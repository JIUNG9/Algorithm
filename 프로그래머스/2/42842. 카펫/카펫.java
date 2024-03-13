import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        //갈색 수와 노란 색의 수의 합의 약수는 만들 수 있는 가로와 세로의 크기다.
        // -> 12라면 [1,12] ,[2,6] [3,4] 가 진행 된다. 9라서 3,3 이라면 두 개를 모두 추가
        // 구현 방법: List에 int[]를 추가한다. a의 숫자가 b보다 큰 것을 기준으로 시작하고 a가 b 보다 작다면 종료한다. a가 큰 값 b가 작은 값을 넣기 위함이다.
        /*
        pseudo
        List<int[]> measure = new ArrayList<>();
        int sum = b + y;
        int a = sum;
        int b  = 1;
        for(; a > b; a--){
        if(sum % a ==0){
                measure.add(int[]{a,b});
            }
        }
        
*/
        // 각 약수를 순회하면서 해당 입력 값의 brown과 일치하는지 확인한다.
        //-> 가로가 6 세로가 2라면  6 * 2 + 2 * 2 - 4가 brown의 개수가 된다. 만약 브라운의 색이 (입력값)같다면 해당 약수를 리턴한다(단 가로가 더 길어야한다.)
        
        //구현 방법: 리스트를 enhanced for loop로 순회를 하면서 brown의 개수와 해당 공식이 일치하는지 확인하고 맞다면 해당 순회 int[]를 반환한다.
        //pseudo code
        /*
        for(int[] arr : measure){
        if(b== arr[0] * 2 + arr[1] * 2 - 4 ){
            return arr;
        }
        }
        
        */
        
        int returnArr[]=new int[2];
         List<int[]> measure = new ArrayList<>();
        int sum = brown + yellow;
        int a = sum;
        int b  = 1;
        for(; a > b; a--){
        if(sum % a ==0){
                measure.add(new int[]{a,sum/a});
             System.out.println("a:" + a);
            System.out.println("b:" + b);
            }
        }
                for(int[] arr : measure){
        if(brown== arr[0] * 2 + arr[1] * 2 - 4 ){
            System.out.println("arr[0]: " +arr[0] );
            System.out.println("arr[1]: " +arr[1] );
            returnArr = arr;
            break;
        }
        }
        return returnArr;
    }
}