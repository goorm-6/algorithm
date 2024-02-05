const input = `5 150
0 50 10
0 50 20
50 100 10
100 151 10
110 140 90`.split("\n");

const [n, d] = input[0].split(" ").map(Number);
let dist = Array.from(Array(d + 1).fill(Infinity));
const graph = Array.from(Array(d + 1), () => []);

for (let i = 0; i < n; i++) {
  const [start, end, w] = input[i + 1].split(" ").map(Number);
  // 150보다 크게되면 역주행이라서 넘겨줘야함
  if (end > d) continue;
  // 지름길이 의미가 없어지면 넘겨줘야함
  if (end - start <= w) continue;
  // 그래프 시작값에 [도착지점, 지름길 거리]
  graph[start].push([end, w]);
}
console.log(graph);
let prev = -1;
for (let i = 0; i <= d; i++) {
  if (i) {
    // 0 빼고 전부 prev 초기화
    prev = dist[i - 1];
  }

  // prev -1 은 여기서 0이 된다. 그리고 나머지 부터는 0부터 + 1 계속 하는거임
  dist[i] = Math.min(dist[i], prev + 1); // 지름길을 제외하고 원래 이동하는 값을 dist에 넣어줌 밑에 반복문에서 지름길로 넣어주면 지름길 부터 +1 해서 증가함

  // 그래프 0일 때 [50 10], [50 20]이 들어가 있음
  for (let [next, cost] of graph[i]) {
    // i=0일 때 inf > 0 + 10이랑 비교해서 dist[50]일 떼 10이 들어감
    // i=50일 때 inf > dost[i] = 10이니까 10 + 10이랑 비교해서 dist[100]일 떼 20이 들어감 이후 +1 계속해서 70
    if (dist[next] > dist[i] + cost) {
      dist[next] = dist[i] + cost;
    }
  }
}
console.log(dist[d]);
