function solution(p) {
  return p
    .split("")
    .map((v, i) => (i < p.length - 4 ? "*" : v))
    .join("");
}
