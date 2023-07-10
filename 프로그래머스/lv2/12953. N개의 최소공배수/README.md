# [level 2] N개의 최소공배수 - 12953 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12953) 


### Approach
모든 숫자의 최소공배수를 구하는 문제이다. 앞에서부터 각 원소끼리의 최소공배수를 구하여 모든 원소와의 최소공배수를 구한다면 그것이 해당 배열의 모든 원소에 대한 최소공배수가 된다. 단 입력값은 100 이하의 숫자이다. 최악의 경우 1부터 100까지 모두의 소수가 나온다면 1부터 100까지의 소수의 곱이 되므로 long의 자료형으로 최소공배수의 값을 담지 못 한다. 따라서 BigInteger를 통해 문제를 해결하면 된다. BigInteger의 자료형의 크기는 2^INTEGER_MAX_VALUE이므로 해당 값을 저장할 수 있다.

### 성능 요약

메모리: 73.3 MB, 시간: 1.17 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

Empty

### 문제 설명

<p>두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요. </p>

<h5>제한 사항</h5>

<ul>
<li>arr은 길이 1이상, 15이하인 배열입니다.</li>
<li>arr의 원소는 100 이하인 자연수입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>arr</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[2,6,8,14]</td>
<td>168</td>
</tr>
<tr>
<td>[1,2,3]</td>
<td>6</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
