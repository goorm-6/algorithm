const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const n = Number(input[0]);
let graph = [];
for (let i = 1; i <= n; i++) graph.push(input[i].split(''));

// 상 하 좌 우
let dx = [-1, 1, 0, 0];
let dy = [0, 0, -1, 1];

function dfs(x, y) {
   if (!visited[x][y]) {
      visited[x][y] = true; // 방문처리
      for (let i = 0; i < 4; i++) {
         let nx = x + dx[i];
         let ny = y + dy[i];
         if (nx < 0  || ny < 0 || nx >= n || ny >= n) continue; // 공간을 벗어나는 경우 무시
         if (graph[x][y] == graph[nx][ny]) dfs(nx, ny); // 같은 색상이라면 재귀적으로 dfs() 호출
      }
      return true;
   }
   return false;
}

// 적록색약 X
let result1 = 0;
let visited = [];
for(let i = 0; i < n; i++) visited.push(new Array(n).fill(false));
for(let i = 0; i < n; i++){
   for(let j = 0; j < n; j++){
      if(dfs(i, j, 0)) result1++;
   }
}

// R -> G 변환 후에 적록색약의 연결요소 세기
for(let i = 0; i < n; i++){
   for(let j = 0; j < n; j++){
      if(graph[i][j] == 'R') graph[i][j] = 'G';
   }
}  

// 적록색약 O
let result2 = 0;
visited = [];
for(let i = 0; i < n; i++) visited.push(new Array(n).fill(false));
for(let i = 0; i < n; i++){
   for(let j = 0; j < n; j++){
      if(dfs(i, j)) result2++;
   }
}

console.log(result1 + ' ' + result2);