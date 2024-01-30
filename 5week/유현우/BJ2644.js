const input = `9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6`.split("\n");

const n = +input.shift();
const [x, y] = input
  .shift()
  .split(" ")
  .map((value) => +value);
const m = +input.shift();

const data = input.map((item) => item.split(" ").map((v) => +v));
const graph = Array.from({ length: n + 1 }).map(() => []);
const visited = Array.from({ length: n + 1 }).map(() => false);
// 1촌 관계를 그래프로 정리
for (let i = 0; i < data.length; i++) {
  const [x, y] = data[i];
  graph[x].push(y);
  graph[y].push(x);
}

const BFS = (start) => {
  if (n === 1) return console.log(-1);
  const queue = [[start, 0]];

  while (queue.length) {
    let [qx, count] = queue.shift();
    let nearQx = graph[qx]; // 1촌 관계 그래프 가져오기
    if (visited[qx]) continue; // 방문체크
    if (qx === y) return count;
    visited[qx] = true;

    // 1촌 관계 반복문으로 순회
    for (let i = 0; i < nearQx.length; i++) {
      let value = nearQx[i];
      if (visited[value]) continue; // 방문체크
      if (value === y) return count + 1; // y값과 일치하면 +1 해서 출력
      queue.push([value, count + 1]);
    }
  }
  return -1;
};

console.log(BFS(x));
