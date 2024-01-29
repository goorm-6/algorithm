const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = require("fs")
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n")
  .map((v) => v.split(" ").map(Number));
const [N, M, _] = input.shift();
const dir = [
  [0, 1],
  [0, -1],
  [-1, 0],
  [1, 0],
];
const graph = Array.from(Array(N), () => Array(M).fill(0));
input.forEach(([r, c]) => (graph[r - 1][c - 1] = 1));

let cnt = 1; // 현재 있는 곳도 카운팅에 포함하기 위해 초기값 1
const dfs = (r, c) => {
  for (let i = 0; i < 4; i++) {
    const x = r + dir[i][0];
    const y = c + dir[i][1];
    if (x >= 0 && x < N && y >= 0 && y < M && graph[x][y]) {
      graph[x][y] = 0;
      cnt++;
      dfs(x, y);
    }
  }
};

let max = 0;
for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (graph[i][j]) {
      graph[i][j] = 0;
      dfs(i, j);
      if (cnt > max) max = cnt;
      cnt = 1; // 초기화
    }
  }
}
console.log(max);
