# [level 2] 올바른 괄호 - 12909 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12909) 

### Approach 
짝이 맞아야하는 문제이므로 스택으로 접근했다. 하지만 효율성의 검사에서 실패하였다. 효율성의 실패한 코드는 이러하다
```
   for(int i = 1; i < s.length(); i++){
        if(!stk.isEmpty() && stk.peek()== '(' && s.charAt(i) == ')'){
        stk.pop();
      }
       else{
         stk.push(s.charAt(i));
      }
    }
    if(!stk.isEmpty()) return false;
    return true;
  }
```
해당 접근은 스택에 ( 가 존재한다면 )를 팝하는 조건이다. 그렇지 않다면 push를 통해서 진행한다.
아래는 효율성을 통과한 코드이다

```
  for(int i = 0; i < s.length(); i++){
      
        if(s.charAt(i) == '('){
            stk.push('(');
        }
      else{
          if(stk.isEmpty()) return false;
          stk.pop();
      }
        
     
    }
```
stack을 peek하지 않고 '(' 일 경우 푸쉬를 한다. 그리고 else statement와 조건을 통해 stk이 비어있을 경우 짝이 맞지 않는다는 의미로 false를 반환한다.

### 성능 요약

메모리: 53.4 MB, 시간: 15.82 ms

### 구분

코딩테스트 연습 > 스택／큐

### 채점결과

Empty

### 문제 설명

<p>괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어</p>

<ul>
<li>"()()" 또는 "(())()" 는 올바른 괄호입니다.</li>
<li>")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.</li>
</ul>

<p>'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.</p>

<h5>제한사항</h5>

<ul>
<li>문자열 s의 길이 : 100,000 이하의 자연수</li>
<li>문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.</li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>s</th>
<th>answer</th>
</tr>
</thead>
        <tbody><tr>
<td>"()()"</td>
<td>true</td>
</tr>
<tr>
<td>"(())()"</td>
<td>true</td>
</tr>
<tr>
<td>")()("</td>
<td>false</td>
</tr>
<tr>
<td>"(()("</td>
<td>false</td>
</tr>
</tbody>
      </table>
<h5>입출력 예 설명</h5>

<p>입출력 예 #1,2,3,4<br>
문제의 예시와 같습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://programmers.co.kr/learn/challenges
