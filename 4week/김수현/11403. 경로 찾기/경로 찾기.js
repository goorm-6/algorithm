const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const n = input.shift();
let graph = [];

for (let row of input) {
   graph.push(row.split(' ').map(Number));
}

//플로이드-와샬
for (let k = 0; k < n; k++) {
   for(let i = 0; i < n; i++) {
      for(let j = 0; j < n; j++) {
         if(graph[i][k]==1 && graph[k][j]==1) {
            graph[i][j] = 1;
         }
      }
   }
}

for (let i = 0; i < n; i++) {
   console.log(graph[i].join(" "));
}
