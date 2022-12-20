const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  const firstAmount = parseInt(input);
  let amount = parseInt(input);
  let count = 0;

  count += Math.floor(amount / 5);
  amount = amount % 5;

  if (amount === 0) return console.log(count);
  if (amount === 3) return console.log(count + 1);

  while (amount < firstAmount) {
    amount += 5;
    count -= 1;
    if (amount % 3 === 0) return console.log(count + Math.floor(amount / 3));
  }

  return console.log(-1);
});
