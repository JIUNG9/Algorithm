class Solution {
    public int solution(String[] b) {
        //3*3 크기
        //선공 -> O 후공 -> X
        //실수를 했다면 -1 , 정상적이라면 O
        
        // 실수를 한 케이스
        //X의 개수가 O의 개수보다 많은 경우(O가 선공 이기에)
        
        //->이겼다를 어떻게 코드로 구현할 수 있을까
        //이기는 경우
    
        /*
        
        [0][0] [1][1] [2][2]
        [0][2] [1][1] [2][0]
        [i][0] [i][1] [i][2]
        셋중 하나의 케이스가 모두 같은 모양인 경우에 이긴 경우
        
        //O가 이겼는데 X를 나두는 경우
        -> 이후 O가 이긴경우 X의 개수가 O와 크거나 같다면 -1
        //X가 이겼는데 O를 나두는 경우
        -> 이후 X가 이긴경우 O의 개수가 X보다 큰 경우 -1
        */
        
        //무승부 -> 무승부 인데 말이 안 되는 경우 -> O가 5개가 아니고 X가 4개가 아닌 경우
        int theNumberOfO= 0;
        int theNumberOfX = 0;
        
        

        
        for(int i = 0; i <3; i++){
            for(int j =0; j<3; j++){
                if(b[i].charAt(j) =='O')theNumberOfO++;
                if(b[i].charAt(j) == 'X')theNumberOfX++;
                
            }
        }
        
        if(theNumberOfO == 0 && theNumberOfX == 0) return 1;
        

        if(isWon(b,'O')){


            if(theNumberOfO <= theNumberOfX) {
                return 0; 
            }
        } 
        if(isWon(b,'X')){
            if(theNumberOfO > theNumberOfX) return 0;
        } 
        
                //순서대로 두지 않은 것만을 나타내는 것
        //theNumberOfO - theNumberOfX != 1 || theNumberOfO - theNumberOfX !=0 -> 순서를 지키지 않았다 ->
        //O를 많이 둔 경우
        //X 를 많이 둔 경우
        if(theNumberOfO - theNumberOfX > 1 || theNumberOfX > theNumberOfO){
                                                                System.out.println("won the O");

            return 0;
        }
        
                
        if(theNumberOfO + theNumberOfX == 9){
            if(theNumberOfO != 5 && theNumberOfX !=4){
                return 0;
            }
        }
        return 1;
        
        
        
        
        
    }
    
    public boolean isWon(String b[], char c){
        //세로, 가로, 대각선 
        
        
            if(b[0].charAt(0) ==c && b[0].charAt(0)==(b[1].charAt(1)) && b[1].charAt(1)==(b[2].charAt(2)) ){
                return true;
            }
        
            if(b[0].charAt(2) == c && b[0].charAt(2)==(b[1].charAt(1))&& b[1].charAt(1)==(b[2].charAt(0))){
                return true;
            }
        
        //가로
            for(int i = 0; i < 3; i++){
                boolean flag = true;
                char  init = b[i].charAt(0);
                if(init != c) continue;
                for(int j = 0; j < 3; j++){
                    if(init != (b[i].charAt(j))){
                     flag = false;   
                    }                         
                }
                if(flag) return true;
            }
        //세로
        for(int i = 0; i < 3; i++){
            boolean flag = true;
            char  init = b[i].charAt(i);
            if(init != c) continue;
                for(int j = 0; j < 3; j++){
                    if(init != b[j].charAt(i)){
                        flag =false;
                    }
            }
            if(flag) return true;
        }
        
        
        return false;
        
        }
        

    
  
  
    

}