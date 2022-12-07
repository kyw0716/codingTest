function solution(my_string, n) {
  return my_string
    .split("")
    .map((w) => {
      let newString = ``;

      for (let i = 0; i < n; i++) {
        newString += `${w}`;
      }

      return newString;
    })
    .join("");
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120825
