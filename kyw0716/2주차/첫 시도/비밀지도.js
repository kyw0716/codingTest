function solution(n, arr1, arr2) {
  let answer = [];
  let arr3 = [];
  arr1.forEach((code, index) => {
    arr1[index] = code.toString(2).padStart(n, 0).split("");
    arr2[index] = arr2[index].toString(2).padStart(n, 0).split("");
  });
  arr1.forEach((code, index) => {
    let concatArray = [...code];
    for (let i = 0; i < n; i++) {
      if (code[i] !== arr2[index][i]) {
        concatArray[i] = 1;
      }
    }
    arr3.push(concatArray);
  });
  arr3.map((code, index) => {
    let result = [];
    for (let i = 0; i < n; i++) {
      if (Number(code[i]) === 1) {
        result.push("#");
      } else {
        result.push(" ");
      }
    }
    answer[index] = result.join("");
  });
  return answer;
}
