const divideUV = (w) => {
  const balance = [0, 0];
  let i, u, v;

  w = w.split("");

  for (i = 0; i < w.length; i++) {
    if (w[i] === "(") balance[0]++;
    if (w[i] === ")") balance[1]++;

    if (balance[0] === balance[1]) break;
  }

  u = w.filter((v, index) => index <= i).join("");
  v = w.filter((v, index) => index > i).join("");

  return [u, v];
};

const getIsStringCorrect = (u) => {
  const stack = [];

  for (let i = 0; i < u.length; i++) {
    stack.push(u[i]);

    if (stack.at(-1) === ")" && stack.at(-2) === "(") {
      stack.pop();
      stack.pop();
    }
  }

  return stack.length === 0;
};

function solution(w) {
  if (w === "") return "";

  let [u, v] = divideUV(w);

  if (getIsStringCorrect(u)) return u + solution(v);

  u = u
    .slice(1, -1)
    .split("")
    .map((v) => {
      if (v === "(") return ")";
      if (v === ")") return "(";
    })
    .join("");

  let newString = "(" + solution(v) + ")" + u;

  return newString;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/60058
