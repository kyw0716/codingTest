function solution(my_str, n) {
  const m = my_str.split("");
  const answer = [];

  for (let i = 0; i < Math.ceil(my_str.length / n); i++) {
    const newS = [];

    for (let j = 0; j < n; j++) {
      const newW = m.shift();
      if (newW) newS.push(newW);
    }

    answer.push(newS.join(""));
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120913
