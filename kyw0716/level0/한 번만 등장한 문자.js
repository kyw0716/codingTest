function solution(s) {
  let answer = "";

  s = s.split("").sort().join("");

  for (let i = 0; i < s.length; i++) {
    if (s[i - 1] !== s[i] && s[i] !== s[i + 1]) answer += s[i];
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120896?language=javascript
