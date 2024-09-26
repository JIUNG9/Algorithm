class Solution {
    private int removedCounter = 0;
    public int[] solution(String s) {
        
        //이진 변화 결과가 1이 될때까지,제거할 0의 개수를 구하고 현재 s길이에서 해당 개수를 뺸 수를 다시 이진 수를 만든다. 이때 제거할 0의 개수의 총합을 구하고, 몇 번 반복했는지 횟수를 구하여, 반복횟수를 배열의 첫 번째 원소로, 제거한 개수를 두 번째 원소로 구하여 반환하여라
        
        int round = 0;
        while(!s.equals("1")){
            System.out.println("s: "+ s);
            round++;
            s = getNextBinary(s);
        }
        
        return new int[]{round, removedCounter};
    }
    public String getNextBinary(String binary){
        //제거할 0의 개수 구하기
        int counter = 0;
        int len = binary.length();
        
        for(int i = 0; i < len; i++){
            if(binary.charAt(i) == '0'){
                counter++;
            }
        }
        //총합 구하기
        removedCounter+=counter;
        //현재 s길이에서 제거할 0의 개수를 뺸 것을 2진수로 변환하기.
        return getBinary(len-counter);
        
    }
    private String getBinary(int number){
        //2진수 변환
        StringBuilder sb = new StringBuilder();
        while(number!=0){
            sb.append(String.valueOf(number%2));
            number/=2;
        }
        return sb.reverse().toString();
    }
}