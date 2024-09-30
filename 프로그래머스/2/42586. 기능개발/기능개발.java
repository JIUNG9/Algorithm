import java.util.*;

class Solution {
    private List<Work> workList;
    public int[] solution(int[] p, int[] s) {
        //모든 작업이 없어질 때까지, 모든 작업을 진행했을 때 가장 앞에 있는 작업이 100이 된다면 선수 작업을 지우고(끝내고) 후 작업 또한 100을 넘는 것들을 지우고 해당 개수들을 센다. 센 개수들을 정답 list에 넣고, 후에 array로 반환한다.
        
        workList = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 0; i < p.length; i++){
            Work w = new Work(p[i],s[i]);
            workList.add(w);
        }
        //모든 작업이 완료될 때까지
        while(workList.size() > 0){
            for(Work w :workList){
                w.workToday();
            }
            int counter = 0;
            //선수 작업이 모두 0일때 개수를 제거, 사이즈가 0보다 클 때
            while(workList.size() > 0 &&workList.get(0).p >= 100){
                counter++;
                workList.remove(0);
            }
            if(counter!=0) answerList.add(counter);
        }
        return answerList.stream().mapToInt(i->i).toArray();
        
    }

    class Work{
        private int p;
        private int s;
        
        public Work(int p, int s){
            this.p = p;
            this.s = s;
        }
        public void workToday(){
            p+=s;
        }

    }

}

