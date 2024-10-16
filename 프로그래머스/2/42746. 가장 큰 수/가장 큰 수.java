import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        //만약 맨 앞의 자리 숫자가 같다면 전체 숫자를 a,b가 있다고 가정할 때 a에 concated한 수와 b에 concated한 수를 비교하여 더 큰 수가 앞에 오도록 한다. 만약 숫자가 다르다면 더 큰 수가 앞에 오도록한다.
        //구현, sort는 reference가 필요하므로 reference타입으로 수정
        StringBuilder sb = new StringBuilder();
        Integer[] num = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(num,(a,b) -> {
           String str1 = String.valueOf(a);
           String str2 = String.valueOf(b);
            if(str1.charAt(0) != str2.charAt(0)) return str2.compareTo(str1);
            else{
                return Integer.compare(Integer.parseInt(str2+str1),Integer.parseInt(str1+str2));
            }
        });
        for(int i = 0; i < num.length; i++){
            sb.append(String.valueOf(num[i]));
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }
}