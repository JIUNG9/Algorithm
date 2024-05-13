import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
     private Map<String, Car> map;
  

  public int[] solution(int[] fees, String[] records) {
    map = new HashMap<>();
    int defaultTime = fees[0];
    int defaultFee = fees[1];
    int interval = fees[2];
    int fee = fees[3];

    for (int i = 0; i < records.length; i++) {
      String[] info = records[i].split(" ");
      String carNumber = info[1];
      LocalTime inOrOutTime = LocalTime.parse(info[0]);
      ParkedStatus status = ParkedStatus.valueOf(info[2]);

      if (status.equals(ParkedStatus.OUT)) {
        Car willBeOutCar = map.get(carNumber);
        willBeOutCar.updateStatus(ParkedStatus.OUT);
        LocalTime timeDifference = getTimeDifference(willBeOutCar.recentInTIme, inOrOutTime);
        willBeOutCar.updateTodayParkedTime(
            willBeOutCar.todayParkedTime.plusHours(timeDifference.getHour())
                .plusMinutes(timeDifference.getMinute()));
      } else if (map.containsKey(carNumber) && status.equals(ParkedStatus.IN)) {
        Car alreadyParkedTodayCar = map.get(carNumber);
        alreadyParkedTodayCar.updateStatus(ParkedStatus.IN);
        alreadyParkedTodayCar.updateRecentInTime(inOrOutTime);
      } else if (status.equals(ParkedStatus.IN)) {
        map.put(carNumber, new Car(carNumber, inOrOutTime, ParkedStatus.IN, LocalTime.MIN));
      }
    }

    List<Car> carList = new ArrayList<>(map.values());
    for (Car stillStatusInCar : carList) {
      if (stillStatusInCar.status.equals(ParkedStatus.IN)) {
        stillStatusInCar.updateStatus(ParkedStatus.OUT);
        LocalTime timeDifferent = getTimeDifference(stillStatusInCar.recentInTIme,
            LocalTime.MIDNIGHT.minusMinutes(1));
        stillStatusInCar.updateTodayParkedTime(timeDifferent.plusHours(
                stillStatusInCar.todayParkedTime.getHour())
            .plusMinutes(stillStatusInCar.todayParkedTime.getMinute()));
      }
    }

    return carList.stream().sorted((c1, c2) -> {
          return c1.carNumber.compareTo(c2.carNumber);
        }).mapToInt(c -> calculateFee(defaultFee, defaultTime, interval, fee, c.todayParkedTime))
        .toArray();

  }


  public LocalTime getTimeDifference(LocalTime in, LocalTime out) {
    return out.minusHours(in.getHour()).minusMinutes(in.getMinute());
  }

  public int calculateFee(int defaultFee, int defaultTime, int interval, int fee,
      LocalTime totalParkedTime) {

    int totalMin = totalParkedTime.getHour() * 60 + totalParkedTime.getMinute();
    if (totalMin > defaultTime) {
      totalMin -= defaultTime;
      int divided = totalMin / interval;
      if (totalMin % interval != 0) {
        divided++;
      }
      return divided * fee + defaultFee;

    } else {
      return defaultFee;
    }
  }


  enum ParkedStatus {
    IN, OUT
  }

  class Car {

    String carNumber;
    LocalTime recentInTIme;
    ParkedStatus status;
    LocalTime todayParkedTime;

    public Car(String carNumber, LocalTime recentInTIme, ParkedStatus status,
        LocalTime todayParkedTime) {
      this.carNumber = carNumber;
      this.recentInTIme = recentInTIme;
      this.status = status;
      this.todayParkedTime = todayParkedTime;
    }

    public void updateRecentInTime(LocalTime currentTime) {
      this.recentInTIme = currentTime;
    }

    public void updateTodayParkedTime(LocalTime todayParkedTime) {
      this.todayParkedTime = todayParkedTime;
    }

    public void updateStatus(ParkedStatus status) {
      this.status = status;
    }

    public LocalTime getTodayParkedTime() {
      return this.todayParkedTime;

    }


  }
}