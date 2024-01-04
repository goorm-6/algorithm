const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
console.log(solution(input));

function solution(input) {
    const answer = [];
    const [N, M] = input.shift().split(' ').map(num => Number(num));
    const matrix = input.shift().split(' ').map(num => Number(num));
    
    let prefixSum = Array.from( { length: N + 1} ).fill(0);

    for (let i = 0; i < N; i++) {
        prefixSum[i + 1] = prefixSum[i] +    matrix[i];
    }

    for (let range of input) {
        const [start, end] = range.split(' ').map(num => Number(num));
        answer.push(prefixSum[end] - prefixSum[start - 1]);
    }

    return answer.join('\n');
}