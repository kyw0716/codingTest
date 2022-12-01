const upSort = (a, b) => {
  return a - b;
};

const fillCount = (count, splitArray) => {
  for (let i = 0; i < splitArray.length; i++) {
    if (count[splitArray[i]]) {
      count[splitArray[i]]++;
      continue;
    }

    count[splitArray[i]] = 1;
  }
};

const fillAllCount = (xCount, yCount, allCount) => {
  for (let i = 0; i < 10; i++) {
    const x = xCount[`${i}`] ? xCount[`${i}`] : 0;
    const y = yCount[`${i}`] ? yCount[`${i}`] : 0;

    allCount[`${i}`] = Math.min(x, y);
  }
};

function solution(X, Y) {
  const xSplit = X.split("");
  const ySplit = Y.split("");
  const xCount = {};
  const yCount = {};
  const allCount = {};
  let answer = "";

  fillCount(xCount, xSplit);
  fillCount(yCount, ySplit);
  fillAllCount(xCount, yCount, allCount);

  for (let i = 9; i > -1; i--) {
    const count = allCount[`${i}`];

    for (let j = 0; j < count; j++) {
      answer += `${i}`;
    }
  }

  if (answer.length === 0) return "-1";
  if (answer.replace(/0/g, "").length === 0) return "0";

  return answer;
}

//https://school.programmers.co.kr/learn/courses/30/lessons/131128
