function solution(strings, n) {
  return strings.sort().sort((a, b) => a[n].charCodeAt() - b[n].charCodeAt());
}
