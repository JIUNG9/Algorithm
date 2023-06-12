# [level 2] 타겟 넘버 - 43165 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43165) 

# Approach
주어진 숫자가 2개이상 20개 이하이므로 완전탐색으로 접근을 한다.
DFS로 해당 문제를 접근한다.

# Implementation
해당 문제는 예시로 4,1,2,1가 있다고 가정하면 모든 수는 동시에 음수로서 계산될 수 있다. 따라서 하나의 가지치기에 4,-4 / 2, -2 / 1,-1/ 1,-1 이 존재할 수 있다.
따라서 해당 문제해결을 DFS를 통해 마지막 depth에서 target값과 같다면 ans을 증가시켜 값을 구한다.

### 성능 요약

메모리: 72.7 MB, 시간: 0.31 ms

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

### 채점결과

Empty

### 문제 설명

<p>n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.</p>
<div class="highlight"><pre class="codehilite"><code>-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
</code></pre></div>
<p>사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>주어지는 숫자의 개수는 2개 이상 20개 이하입니다.</li>
<li>각 숫자는 1 이상 50 이하인 자연수입니다.</li>
<li>타겟 넘버는 1 이상 1000 이하인 자연수입니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>numbers</th>
<th>target</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>[1, 1, 1, 1, 1]</td>
<td>3</td>
<td>5</td>
</tr>
<tr>
<td>[4, 1, 2, 1]</td>
<td>4</td>
<td>2</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>
<div class="highlight"><pre class="codehilite"><code>+4+1-2+1 = 4
+4-1+2-1 = 4
</code></pre></div>
<ul>
<li>총 2가지 방법이 있으므로, 2를 return 합니다.</li>
</ul>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
