function solution(arr1, arr2) {
  var answer = [];

  for (let i = 0; i < arr1.length; i++) {
    let subArr = [];
    const arr1Sub = arr1[i];

    for (let j = 0; j < arr2[0].length; j++) {
      let sum = 0;
      for (let k = 0; k < arr2.length; k++) {
        sum += arr1[i][k] * arr2[k][j];
      }
      subArr.push(sum);
    }
    answer.push(subArr);
  }
  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12949
