import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        //주차 기록을 모두 조회하여, IN일 경우에 차량 넘버, 입차 시각, 입차 상태를 표시한다.
        //만약 저장소에 이미 기록이 존재한다면 해당 차량을 조회하고 출차 시각(분)과 입차 시각을 뺴고 기본시각 이하라면 기본 요금을 청구, 만약 초과한다면 기본 요금 + 초과한 시간만큼 단위시간을 나눠 단위 요금을 청구 만약 나눠떨어지지 않는다면 단위 시간을 하나 더 더해서 요금을 청구, 청구한 이후에는 해당 차량 넘버와 요금을 저장 그리고 해당 차량의 상태를 다시 OUT으로 만들어준다. 만약 모든 레코드를 확인하였는데 차량의 입차 기록이 IN만 남아있을 경우 23:59을 출차로 여기고 해당 IN 차량들을 모두 OUT으로 여긴다. 이후 차량 넘버를 오름차순으로 하여 요금만을 추출해 반환한다.
        //-> 실수: 누적합을 고려하지 않음
        Map<String,Car> map = new HashMap<>();
        List<Car> answerList = new ArrayList<>();
        

        
        for(int i = 0; i < records.length; i++){
            String[] arr = records[i].split(" ");
            String[] time = arr[0].split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String carNumber = arr[1];
            String status = arr[2];
            if(status.equals("IN")){
                //나간 뒤에 재입차한
                if(map.containsKey(carNumber)){
                    Car car = map.get(carNumber);
                    car.setStatus("IN");
                    car.setInTime(min);
                    car.setOutTime(0);
                }
                else{
                    Car car = new Car(carNumber,min);
                    map.put(carNumber,car);
                }
            }
            else{
                //나가기 -> 이때 입차는 무조건 존재
                Car car = map.get(carNumber);
                car.setStatus("OUT");
                car.setOutTime(min);
                car.parkingSum += (car.outMin - car.inMin);
                car.setFee(calcaluateFee(fees, car.parkingSum));
                if(!answerList.contains(car)) answerList.add(car);
                
            }
            
        
        }
        for(Car c : map.values()){
            if(c.parkingStatus.equals("IN")){
                int fee = calcaluateFee(fees, (23 * 60 + 59) - c.inMin + c.parkingSum );
                c.setStatus("OUT");
                c.setOutTime(23 * 60 + 59);
                c.setFee(fee);
                if(!answerList.contains(c)) answerList.add(c);
            }
        }
        return answerList.stream().sorted((car1,car2)->{
            return Integer.compare(Integer.parseInt(car1.carNum),Integer.parseInt(car2.carNum));
        }).mapToInt(car1 -> car1.fee).toArray();
        
        
    }
        
        public int calcaluateFee(int[] f , int parkingMin){
        
            int defaultTime = f[0];
            int defaultFee = f[1];
            int criteriaTime = f[2];
            int feePerCriteria = f[3];
            if(parkingMin <= defaultTime) return defaultFee;
            else{
                int fee = (((parkingMin - defaultTime) / criteriaTime) * feePerCriteria) + defaultFee;
                if((parkingMin - defaultTime) % criteriaTime != 0) fee += feePerCriteria;
                
                return fee;
            }
            
        }
        
    }
    class Car{
         int fee;
         String parkingStatus;
         String carNum;
         int inMin;
         int outMin;
         int parkingSum;
        
        
        public Car(String carNum, int inMin){
            this.fee = 0;
            this.parkingStatus ="IN";
            this.inMin = inMin;
            this.carNum = carNum;
            this.outMin = 0;
            this.parkingSum = 0;
        }
        
        public void setFee(int fee){
            this.fee = fee;
        }
        public void setStatus(String parkingStatus){
            this.parkingStatus = parkingStatus;
        }
        public void setInTime(int inMin){
            this.inMin = inMin;
        }
         public void setOutTime(int outMin){
            this.outMin = outMin;
        }
        @Override
        public String toString(){
            System.out.println("car: " );
            System.out.println(this.carNum);
            System.out.println(this.parkingStatus);
            System.out.println( this.inMin);
            System.out.println( this.outMin);
            System.out.println(this.fee);
            return "car system out";
            
        }
    }
    
    
