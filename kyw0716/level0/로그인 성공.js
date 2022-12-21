function solution(id_pw, db) {
  const ids = [];
  const pwds = [];

  db.forEach((arr) => {
    ids.push(arr[0]);
    pwds.push(arr[1]);
  });

  if (ids.includes(id_pw[0])) {
    if (pwds[ids.indexOf(id_pw[0])] === id_pw[1]) return "login";
    return "wrong pw";
  }
  return "fail";
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120883
