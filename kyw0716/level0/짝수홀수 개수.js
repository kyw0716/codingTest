function solution(num_list) {
  const answer = [0, 0];

  for (let i = 0; i < num_list.length; i++) {
    if (num_list[i] % 2 === 0) {
      answer[0]++;
      continue;
    }

    answer[1]++;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120824
