import java.util.*;

class Solution {
  public int solution(int x, int y, int n) {
        Queue<xStatus> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        initQueue(q,x);
        int result = bfs(q,x,y,n,s);
     System.out.println(result);
        return result;



    }
    public void initQueue(Queue<xStatus> q, int x){
        q.add(new xStatus(x,0));
    }


    public int bfs(Queue<xStatus> q, int x, int y, int n, Set<Integer> set){


        while(!q.isEmpty()){

            xStatus status = q.poll();
            int currentX = status.getX();
            int currentCounter = status.getCounter();

        if(currentX==y) {
            return currentCounter;

        }
            else if(currentX < y && !set.contains(currentX)){
                if(currentX * 3 <= y) {
                    q.add(new xStatus(currentX *3 , currentCounter+1));
                    set.add(currentX);
                }
                if(currentX * 2 <= y) {
                    q.add(new xStatus(currentX *2 , currentCounter+1));
                    set.add(currentX);

                }
                if(currentX + n <= y) {
                    q.add(new xStatus(currentX + n , currentCounter+1));
                    set.add(currentX);

                }
            }

        }

        return -1;
    }
    class xStatus{
        private final int x;
        private final int counter;

        public xStatus(int x, int counter){
            this.x = x;
            this.counter = counter;
        }

        public int getX(){
            return this.x;
        }
        public int getCounter(){
            return this.counter;
        }
    }
}