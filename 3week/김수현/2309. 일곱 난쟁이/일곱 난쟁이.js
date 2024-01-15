const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n').map(Number);

// 모든 요소의 합
const sum = input.reduce((acc, cur) => acc + cur, 0);
let result = [];

for (let i = 0; i < input.length; i++) {
    for (let j = i + 1; j < input.length; j++) {
        const partialSum = input[i] + input[j];

        if (sum - partialSum === 100) {
            result = input.filter(x => x !== input[i] && x !== input[j]).sort((a, b) => a - b);
            break;
        }
    }
}
console.log(result.join('\n'));