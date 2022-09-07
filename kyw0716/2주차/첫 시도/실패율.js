function solution(N, stages) {
  let answer = Array(N)
    .fill(0)
    .map((value, index) => index + 1);
  let challenge = Array(N + 1).fill(0);
  stages.forEach((stage) => {
    challenge[stage - 1] += 1;
  });
  console.log(challenge);
  challenge = challenge.map((remainPeople, index, original) => {
    if (index === 0) return remainPeople / stages.length;
    return (
      remainPeople /
      (remainPeople +
        original.slice(index + 1).reduce((sum, curr) => sum + curr, 0))
    );
  });
  console.log(challenge.slice(0, -1));
  answer.sort((a, b) => challenge[b - 1] - challenge[a - 1]);

  return answer;
}
//다시 풀어보자... 코드 너무 더럽잖아 ㅡㅡ
