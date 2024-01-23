const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n").map(Number);

let result = null;

function solution(input) {
    const sum = input.reduce((a, b) => a + b, 0);

    for (let i = 0; i < input.length - 1; i++) {
        for (let j = i + 1; j < input.length; j++) {
            if (sum - input[i] - input[j] === 100) {
                result = input.filter(x => x !== input[i] && x !== input[j]);
                break;
            }
        }
        if(result) {
            break;
        }
    }

    return result.sort((a, b) => a - b).join('\n');
}

console.log(solution(input));