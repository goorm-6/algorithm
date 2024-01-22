const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

function dfs(graph, n, m, x, y) { // 깊이 우선 탐색
   //주어진 범위 벗어나면 즉시 종료
   if (x <= -1 || x>= n || y <= -1 || y >= m){
      return false;
   }
   //현재 노드 처리 안했으면
   if (graph[x][y] == 1) {
      graph[x][y] = -1; //현재 노드 방문 처리
      // 상 하 좌 우 재귀 호출
      dfs(graph, n, m, x + 1, y);
      dfs(graph, n, m, x, y - 1);
      dfs(graph, n, m, x - 1, y);
      dfs(graph, n, m, x, y + 1);
      return true;
   }
   return false;
}

let testCase = Number(input[0]); // 테스트 케이스
let line = 1;
while (testCase--){
   const [m, n, k] = input[line].split(' ').map(Number); 
   let graph = [];
   for (let i = 0; i < n; i++) {
      graph[i] = new Array(m);
   }
   for (let i = 1; i <= k; i++) {
      let [y, x] = input[line + i].split(' ').map(Number);
      graph[x][y] = 1;
   }
   let answer = 0; // 연결 요소 계산
   for (let i = 0; i < n; i++) {
      for (let j = 0; j < m; j++) {
         if (dfs(graph, n, m, i, j)) answer++;
      }
   }
   line += k + 1; //다음 테스트 케이스로 이동
   console.log(answer);
}