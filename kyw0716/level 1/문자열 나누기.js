function divideString(string, count) {
  const firstAlphabet = string[0];
  let index = 0;
  let sameCount = 1;
  let diffCount = 0;

  if (string === "") return count;

  while (sameCount !== diffCount) {
    index++;
    if (string[index] === firstAlphabet) {
      sameCount++;
      continue;
    }
    diffCount++;
  }

  return divideString(string.slice(index + 1), count + 1);
}

function solution(s) {
  return divideString(s, 0);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/140108
