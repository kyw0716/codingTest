const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  const inputNumber = parseInt(input);
  let result;

  for (let i = 1; i <= inputNumber; i++) {
    const sum =
      i +
      String(i)
        .split("")
        .map(Number)
        .reduce((a, c) => a + c, 0);
    if (sum === inputNumber) {
      result = i;
      break;
    }
  }

  if (result) return console.log(result);
  console.log(0);
});
