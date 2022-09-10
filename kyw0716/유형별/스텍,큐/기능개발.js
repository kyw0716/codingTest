function solution(progresses, speeds) {
  var answer = [];
  progresses.forEach((progress, index) => {
    let day = 0;
    while (progress < 100) {
      progress += speeds[index];
      day++;
    }
    answer.push(day);
  });
  let frontProgress = [answer[0]];
  let count = [0];

  answer.forEach((value) => {
    if (value > frontProgress.at(-1)) {
      count.push(1);
      frontProgress.push(value);
    } else {
      count[count.length - 1] = count.at(-1) + 1;
    }
  });

  return count;
}

// span 계산 하는 방식 익히자.
// https://school.programmers.co.kr/learn/courses/30/lessons/42586
