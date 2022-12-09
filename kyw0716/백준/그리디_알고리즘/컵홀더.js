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

  if (count === 2) rl.close();
}).on("close", () => {
  inputs[0] = parseInt(inputs[0]);
  inputs[1] = inputs[1].replace(/LL/g, "L").split("").length;

  console.log(inputs[0] === inputs[1] ? inputs[0] : inputs[1] + 1);
});
