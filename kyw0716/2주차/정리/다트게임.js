function solution(dartResult) {
  let answer = 0;
  let stopPoint = 0;
  let score = [0, 0, 0];
  const splitResult = [];

  // 주어진 문자열을 각 기회별로 잘라서 splitResult에 저장
  dartResult.split("").forEach((value, index) => {
    if (["S", "D", "T"].includes(value)) {
      if (["*", "#"].includes(dartResult[index + 1])) {
        splitResult.push(dartResult.slice(stopPoint, index + 2));
        stopPoint = index + 2;
      } else {
        splitResult.push(dartResult.slice(stopPoint, index + 1));
        stopPoint = index + 1;
      }
    }
  });

  // 각 기회별로 원점수, 보너스, 옵션을 분리하고 그에 따른 점수를 score에 저장
  splitResult.forEach((result, chance) => {
    let originalScore = result.split(/S|D|T/).join("").split(/\*|\#/).join("");
    let bonus = result.split(originalScore).join("").split(/\*|\#/).join("");
    let option = result.split(originalScore).join("").split(bonus).join("");
    score[chance] =
      originalScore ** (bonus === "S" ? 1 : bonus === "D" ? 2 : 3);
    if (option === "#") {
      score[chance] *= -1;
    }
    if (option === "*") {
      score[chance] *= 2;
      score[chance - 1] *= 2;
    }
  });
  return score.reduce((sum, curr) => sum + curr, 0);
}

// 일단 문제가 길면 문제부터 정확히 이해하고 코드 치기 시작하자.
// 정규표현식 사용하면 조건문 엄청 줄일 수 있으니까 잘 써먹어보자.
// https://school.programmers.co.kr/learn/courses/30/lessons/17682
