const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inputs = [];
let count = 0;

rl.on("line", (input) => {
  inputs.push(input);
  count++;

  if (count === 3) rl.close();
}).on("close", () => {
  let A = inputs[1].split(" ").map((v) => parseInt(v));
  let B = inputs[2].split(" ").map((v) => parseInt(v));
  let S = 0;

  A.sort((a, b) => a - b);
  B.sort((a, b) => b - a);

  for (let i = 0; i < A.length; i++) {
    S += A[i] * B[i];
  }

  console.log(S);
});
