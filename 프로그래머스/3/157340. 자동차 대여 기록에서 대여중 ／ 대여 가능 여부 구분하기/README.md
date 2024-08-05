# [level 3] 자동차 대여 기록에서 대여중 / 대여 가능 여부 구분하기 - 157340 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/157340) 

### Domain
1. There can be same car_id with different history_id. Because the same number car can be borrowed with different duration of rental

### Impl
1. Union two of tables which one is not rented another one rented at '2022-10-16', Use the not in operator even get the car_id which can be borrowed. There will be the row which is rented at another row. so get rented car at '2022-10-16' and use the not in clause
