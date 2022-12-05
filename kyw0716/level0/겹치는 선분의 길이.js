function solution(lines) {
  lines = lines.map((line) => {
    const newLine = [];

    for (let i = line[0]; i < line[1]; i++) {
      newLine.push(i);
    }

    return newLine;
  });

  lines = lines.reduce((acc, curr) => [...acc, ...curr], []);
  lines = lines.filter((v, i) => lines.indexOf(v) !== i);

  return new Set(lines).size;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120876
