function solution(babbling) {
  let answer = 0;

  for (let i = 0; i < babbling.length; i++) {
    if (babbling[i].replace(/aya|ye|woo|ma/g, "").length === 0) answer++;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120956
