function solution(numbers) {
  var answer = [];
  numbers = numbers.map((v) => {
    let v2 = v.toString(2);
    let full = 2;
    while (true) {
      if (full - 1 >= v2.length) break;
      full *= 2;
    }
    return v2.padStart(full - 1, "0");
  });
  for (let i = 0; i < numbers.length; i++) {
    let repeat = -1;
    let len = numbers[i].length + 1;
    let possible = true;
    while (len !== 1) {
      len = len / 2;
      repeat += 1;
    }
    let startNum = 2;
    let addNum = 4;
    let searchNum = 1;
    for (let j = 0; j < repeat; j++) {
      for (let k = startNum; k < numbers[i].length; k += addNum) {
        if (numbers[i][k - 1] === "0" && numbers[i][k - searchNum - 1] === "1")
          possible = false;
        if (numbers[i][k - 1] === "0" && numbers[i][k + searchNum - 1] === "1")
          possible = false;
      }
      startNum *= 2;
      addNum *= 2;
      searchNum *= 2;
    }
    if (possible) answer.push(1);
    else answer.push(0);
  }
  return answer;
}
