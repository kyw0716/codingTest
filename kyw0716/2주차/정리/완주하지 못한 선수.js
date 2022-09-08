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

// 배열로 풀기 힘들때 해시맵도 한번 생각해보자.
// 해시맵에서 value로 key값을 찾는 방법 => Object.keys(hash).forEach((key)=>{if(hash[key] === value) return key}); 요런식으로 ㄱㄱ
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
