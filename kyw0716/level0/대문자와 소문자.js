function solution(my_string) {
  return my_string
    .split("")
    .map((v) => {
      if (v.match(/[a-z]/) !== null) return v.toUpperCase();
      if (v.match(/[A-Z]/) !== null) return v.toLowerCase();
    })
    .join("");
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120893
