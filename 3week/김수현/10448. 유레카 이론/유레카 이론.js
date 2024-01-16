const [N, ...input] = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n').map(Number);

let tri = [];
for (let i = 1; i <= 45; i++) {
    tri.push( i * (i + 1) / 2); // 1000 부근의 삼각수
}

for(let i of input) {
    let result = 0;
    for (let x of tri) {
        for (let y of tri) {
            for (let z of tri) {
                if (x + y + z === i) {
                    result = 1;
                }
            }
        }
    }
    console.log(result);
}