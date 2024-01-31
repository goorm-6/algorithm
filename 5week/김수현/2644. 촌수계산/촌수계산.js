const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const n = Number(input.shift());
const [x, y] = input.shift().split(" ").map(Number);
const m = Number(input.shift());
const data = input.map((item) => item.split(" ").map(Number));

const graph = Array.from({ length: n + 1 }).map(() => []);
const visited = Array.from({ length: n + 1 }).map(() => false);

// 1촌 관계를 그래프로 정리
for (let i = 0; i < data.length; i++) {
   const [x, y] = data[i];
   graph[x].push(y);
   graph[y].push(x);
}

// 사람수가 1이면 촌수 계산이 불가능, -1 출력
if (n === 1) return console.log(-1);

function BFS(start) {
   const queue = [[start, 0]];

   while (queue.length) {
      let [qx, count] = queue.shift();
      let nearQx = graph[qx]; // 1촌 관계 그래프 가져오기
      if (visited[qx]) continue; // 방문했을 경우 건너뜀
      if (qx === y) return count; //끝까지 도달한 경우
      visited[qx] = true; //현재 노드 방문처리

      // 인접 노드 순회
      for (let i = 0; i < nearQx.length; i++) {
         let value = nearQx[i];
         if (visited[value]) continue; 
         if (value === y) return count + 1; 
         queue.push([value, count + 1]);
      }
   }
   return -1;
};

console.log(BFS(x));