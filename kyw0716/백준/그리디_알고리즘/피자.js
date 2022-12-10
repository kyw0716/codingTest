const readline = require("readline");
const inputs = [];

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let count = 0;

rl.on("line", (input) => {
  inputs.push(input);
  count++;
  if (parseInt(inputs[0]) + 1 === count) rl.close();
}).on("close", () => {
  inputs.shift();
  let answer = 0;
  let count34 = 0;
  let count14 = 0;
  let count12 = 0;

  inputs.forEach((v) => {
    if (v === "3/4") count34++;
    if (v === "1/4") count14++;
    if (v === "1/2") count12++;
  });

  answer += count34;
  count14 = count14 > count34 ? count14 - count34 : 0;

  answer += Math.floor(count12 / 2);
  count12 = count12 % 2;

  answer += count12;
  count14 = count12 > 0 ? (count14 <= 2 ? 0 : count14 - 2) : count14;

  answer += Math.floor(count14 / 4);
  answer += count14 % 4 > 0 ? 1 : 0;

  console.log(answer);
});
