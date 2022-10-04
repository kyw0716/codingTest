function check(arr) {
  let stack = [];
  const matchMap = {
    "}": "{",
    "]": "[",
    ")": "(",
  };
  for (let i = 0; i < arr.length; i++) {
    if (stack.at(-1) === matchMap[arr[i]] && stack.at(-1) !== undefined)
      stack.pop();
    else stack.push(arr[i]);
  }
  return stack.length === 0;
}

function solution(s) {
  var answer = [];
  let rap = s.length;
  let arr = s.split("");
  for (let i = 0; i < rap; i++) {
    answer.push(check(arr));
    arr.unshift(arr.pop());
  }

  return answer.filter((v) => v).length;
}
