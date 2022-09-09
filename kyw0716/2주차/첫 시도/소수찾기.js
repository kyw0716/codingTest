function solution(n) {
  let s = new Set();
  for (let i = 1; i <= n; i += 2) {
    if (i !== 1) s.add(i);
  }
  s.add(2);
  for (let i = 3; i < Math.sqrt(n); i++) {
    if (s.has(i)) {
      for (let k = i * 2; k <= n; k += i) {
        s.delete(k);
      }
    }
  }
  return s.size;
}
