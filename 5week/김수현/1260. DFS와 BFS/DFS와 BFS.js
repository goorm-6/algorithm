const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

function dfs(graph, startNode) {
   const visited = [];
   let needVisit = [];

   needVisit.push(startNode);
   while(needVisit.length !==0){
      const node = needVisit.pop();
      if(!visited.includes(node)){
         visited.push(node);
         let nodes = graph[node];
         needVisit = [...needVisit, ...nodes.sort((a, b) => b - a)];
      }
   }

   return visited;
};

function bfs(graph, startNode){
   const visited = [];
   let needVisit = [];

   needVisit.push(startNode);

   while(needVisit.length !==0){
      const node = needVisit.shift();
      if(!visited.includes(node)){
         visited.push(node);
         let nodes = graph[node];
         needVisit = [...needVisit, ...nodes.sort((a, b) => a - b)];
      }
   }

   return visited;
}

let [n, edge, start] = input.shift().split(' ').map(Number);
let graph = [...Array(n + 1)].map(e => []);

for(let i = 0 ; i < edge ; i++){
   let [from, to] = input[i].split(' ').map(Number);
   graph[from].push(to);
   graph[to].push(from);
}

console.log(dfs(graph, start).join(' '));
console.log(bfs(graph, start).join(' '));