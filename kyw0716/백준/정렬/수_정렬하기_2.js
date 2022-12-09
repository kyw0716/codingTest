const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const numbers = [];

rl.on("line", (input) => {
  numbers.push(input);
}).on("close", () => {
  const [N, ...numberList] = numbers.map(Number);
  const result = numberList.sort((a, b) => a - b);
  console.log(result.join("\n"));
});
