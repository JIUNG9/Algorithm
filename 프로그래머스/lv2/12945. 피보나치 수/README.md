# [level 2] 피보나치 수 - 12945 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12945) 

### Approach
피보나치의 수를 구하는 문제이다. 입력값이 100,000이하의 자연수이기 때문에 재귀적으로 피보나치를 구하는 것은 시간 복잡도가 초과한다. 따라서 배열을 미리 생성하여 문제를 해결한다. 여기서 배열을 먼저 생성하고 나머지 연산자를 통해서 계산하려고 한다면 높은 숫자 때문에 Long으로도 해결할 수가 없다. 따라서 배열을 저장할 때 미리 1234567로 나머지 연산을 통해 결과를 저장한다.

### 성능 요약

메모리: 131 MB, 시간: 43.73 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

Empty

### 문제 설명

<p>피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다. </p>

<p>예를들어 </p>

<ul>
<li>F(2) = F(0) + F(1) = 0 + 1 = 1</li>
<li>F(3) = F(1) + F(2) = 1 + 1 = 2</li>
<li>F(4) = F(2) + F(3) = 1 + 2 = 3</li>
<li>F(5) = F(3) + F(4) = 2 + 3 = 5</li>
</ul>

<p>와 같이 이어집니다.</p>

<p>2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.</p>

<h5>제한 사항</h5>

<ul>
<li>n은 2 이상 100,000 이하인 자연수입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>3</td>
<td>2</td>
</tr>
<tr>
<td>5</td>
<td>5</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.</p>

<h5>문제가 잘 안풀린다면😢</h5>

<p>힌트가 필요한가요? [코딩테스트 연습 힌트 모음집]으로 오세요! → <a href="https://school.programmers.co.kr/learn/courses/14743?itm_content=lesson12945" target="_blank" rel="noopener">클릭</a></p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
