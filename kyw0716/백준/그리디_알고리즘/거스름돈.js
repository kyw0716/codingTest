const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  const inputNumber = parseInt(input);
  const pay = 1000;
  const change = [500, 100, 50, 10, 5, 1];
  let remain = pay - inputNumber;
  let index = 0;
  let count = 0;

  while (remain > 0) {
    if (remain - change[index] >= 0) {
      count++;
      remain -= change[index];
      continue;
    }
    index++;
  }

  console.log(count);
});
