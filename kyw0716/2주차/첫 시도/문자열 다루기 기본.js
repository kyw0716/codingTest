function solution(s) {
  return (
    (s.length === 4 || s.length === 6) && s.replace(/\d/g, "").length === 0
  );
}
