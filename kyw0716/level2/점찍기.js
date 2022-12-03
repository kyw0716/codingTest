function solution(k, d) {
  const endPoint = d / k;
  let answer = 0;

  for (let i = 0; i <= endPoint; i++) {
    const X = i * k;
    answer += Math.floor(Math.sqrt(d ** 2 - X ** 2) / k) + 1;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/challenges?order=recent&statuses=solved&levels=2%2C3&languages=javascript&page=1
