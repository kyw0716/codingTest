function solution(k, ranges) {
  const woobak = [];
  const woobakArea = [];
  const answer = [];

  while (k !== 1) {
    woobak.push(k);

    if (k % 2 === 0) {
      k = k / 2;
      continue;
    }

    k = k * 3 + 1;
  }

  woobak.push(1);

  for (let i = 1; i < woobak.length; i++) {
    woobakArea.push((woobak[i - 1] + woobak[i]) / 2);
  }

  for (let i = 0; i < ranges.length; i++) {
    const start = ranges[i][0];
    const end = ranges[i][1];

    let areaSum = 0;

    if (start > woobakArea.length + end) {
      answer.push(-1);
      continue;
    }

    for (let j = start; j <= woobakArea.length + end - 1; j++) {
      areaSum += woobakArea[j];
    }

    answer.push(areaSum);
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/134239
