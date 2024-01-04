const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
console.log(solution(input));

function solution(input) {
    const answer = [];
    const N = +input.shift();
    const matrix = input.shift().split(' ').map(num => Number(num));
    const prefixSum = Array.from( {length: N + 1}).fill(0);

    for (let i = 0; i < N; i++) {
        prefixSum[i + 1] = prefixSum[i] + matrix[i];
    }

    const M = +input.shift();
    for (const range of input) {
        const [start, end] = range.split(' ').map(num => Number(num));
        answer.push(prefixSum[end] - prefixSum[start - 1]);
    }

    return answer.join('\n');
}