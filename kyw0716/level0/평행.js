function getIsParallel(dots, index) {
  let isParallel = false;
  const x1 = dots[0][0] - dots[index][0];
  const y1 = dots[0][1] - dots[index][1];

  dots = dots.filter((v, i) => i > 0 && i !== index);

  const x2 = dots[0][0] - dots[1][0];
  const y2 = dots[0][1] - dots[1][1];

  if (y1 / x1 === y2 / x2) isParallel = true;

  console.log(y1 / x1, y2 / x2);

  return isParallel;
}

function solution(dots) {
  var answer = 0;

  for (let i = 1; i < 4; i++) {
    if (getIsParallel(dots, i)) {
      answer = 1;
      break;
    }
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120875
