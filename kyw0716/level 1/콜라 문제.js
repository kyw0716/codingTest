function solution(require, returnedBottle, ownBottle) {
  let answer = 0;
  let remain = 0;

  while (ownBottle > 0) {
    const newBottles =
      Math.floor((ownBottle + remain) / require) * returnedBottle;

    remain = (ownBottle + remain) % require;
    ownBottle = newBottles;
    answer += ownBottle;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/132267
