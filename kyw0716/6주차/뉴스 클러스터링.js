function solution(str1, str2) {
  var answer = 0;
  let a = [];
  let b = [];
  let gyo = [];
  let hab = [];

  str1 = str1.toLowerCase();
  str2 = str2.toLowerCase();
  while (true) {
    if (str1.length > 0 && str1.slice(0, 2).match(/[a-z]{2}/i) !== null) {
      a.push(str1.slice(0, 2));
    }
    if (str2.length > 0 && str2.slice(0, 2).match(/[a-z]{2}/i) !== null) {
      b.push(str2.slice(0, 2));
    }
    str1 = str1.slice(1);
    str2 = str2.slice(1);
    if (str1.length === 0 && str2.length === 0) break;
  }
  let c = [...a];
  c.forEach((word) => {
    if (b.includes(word)) {
      a.splice(a.indexOf(word), 1);
      b.splice(b.indexOf(word), 1);
      gyo.push(word);
    }
  });
  gyo = gyo.length;
  hab = gyo + a.length + b.length;
  if (gyo === 0 && hab > 0) return 0;
  if (gyo === 0 && hab === 0) return 65536;

  answer = Math.floor((gyo / hab) * 65536);
  return answer === 0 ? 65536 : answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/17677
