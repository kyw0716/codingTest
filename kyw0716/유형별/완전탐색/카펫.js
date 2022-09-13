function solution(brown, yellow) {
  var answer = [];
  let divisionArray = [];
  for (let i = 1; i <= Math.ceil(Math.sqrt(yellow)); i++) {
    let subArray = [];
    if (yellow % i === 0) {
      subArray.push(yellow / i);
      subArray.push(i);
      divisionArray.push(subArray);
    }
  }

  divisionArray = divisionArray
    .filter((subArray) => {
      return 2 * (subArray[0] + subArray[1]) + 4 === brown;
    })
    .map((subArray) => {
      return subArray.map((v) => v + 2).sort((a, b) => b - a);
    });

  return divisionArray[0];
}

// 규칙성 찾아서 그거에 대해 전부 탐색하도록 만들자.
// https://school.programmers.co.kr/learn/courses/30/lessons/42842
