const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inputs = [];
let count = 0;

rl.on("line", (input) => {
  inputs.push(input);
  count += 1;

  if (count === 2) rl.close();
}).on("close", () => {
  const order = inputs[1].split(" ").map(Number);
  const result = [];

  order.forEach((v, i) => {
    result.splice(i - v, 0, i + 1);
  });

  console.log(result.join(" "));
});
