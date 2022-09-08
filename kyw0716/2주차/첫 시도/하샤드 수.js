function solution(x) {
  return (
    x %
      String(x)
        .split("")
        .reduce((s, c) => s + Number(c), 0) ===
    0
  );
}
