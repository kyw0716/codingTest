function solution(participant, completion) {
  let answer = "";
  let hash = {};
  [...new Set([...participant])].forEach((name) => {
    hash[name] = 0;
  });
  participant.forEach((name) => {
    hash[name] += 1;
  });
  completion.forEach((name) => {
    hash[name] -= 1;
  });
  Object.keys(hash).forEach((key) => {
    if (hash[key] === 1) answer = key;
  });

  return answer;
}
