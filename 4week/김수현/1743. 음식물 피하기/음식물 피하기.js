const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n').map((v) => v.split(' ').map(Number));;
const [n, m, k] = input.shift();
let graph = Array.from(Array(n), () => Array(m).fill(0));
input.forEach(([r, c]) => graph[r - 1][c - 1] = 1);

let dx = [-1, 1, 0, 0];
let dy = [0, 0, -1, 1];
let cnt = 1;

//상하좌우에 대하여 연결요소 세기
function dfs(r, c) {
   for(let i = 0; i < 4; i++) { 
      let x = r + dx[i];
      let y = c + dy[i];
      if (x >= 0 && x < n && y >= 0 & y < m && graph[x][y] == 1) {
         graph[x][y] = 0; //방문처리
         cnt++;
         dfs(x,y); //재귀 호출
      }
   }
}

let max = 0;
for (let i = 0; i < n; i++) {
   for (let j = 0; j < m; j++) {
      if (graph[i][j] == 1) {
         graph[i][j] = 0;
         dfs(i, j);
         if (cnt > max) max = cnt;
         cnt = 1; // 카운트 초기화
      }
   }
}
console.log(max);