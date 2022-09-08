process.stdin.setEncoding("utf8");
process.stdin.on("data", (data) => {
  const n = data.split(" ");
  const a = Number(n[0]),
    b = Number(n[1]);
  for (let i = 0; i < b; i++) {
    for (let j = 0; j < a; j++) {
      process.stdout.write("*");
    }
    process.stdout.write("\n");
  }
});

// console.log는 기본적으로 줄바꿈이 되어있는 출력이라 줄바꿈을 하지 않고 싶다면 process.stdout.write함수를 사용해야 한다.
// https://school.programmers.co.kr/learn/courses/30/lessons/12969
