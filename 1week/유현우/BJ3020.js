const input = `6 7
1
5
3
3
5
1`.trim().split('\n');
console.log(solution(input));

function solution(input) {
    const [N, H] = input.shift().split(' ').map(num => Number(num));
    //첫 번째 장애물은 항상 석순이고, 그 다음에는 종유석과 석순이 번갈아가면서 등장한다.
    const S = Array.from( {length: H + 1} ).fill(0);
    const J = Array.from( {length: H + 1} ).fill(0);
    initializeObstacles(S, J, N, input);
    calculatePrefixSumObstacles(S, J, H);
    
    const obstacleDetails = calculateBrokenObstacleDetails(S, J, H);
    const min = Math.min(...obstacleDetails);
    const count = obstacleDetails.filter(num => num == min).length;

    return [min, count].join(' ');
}

function initializeObstacles(S, J, N, input) {
    for (let i = 0; i < N/2; i++) {
        S[getObstaclesHeight(input)] += 1;
        J[getObstaclesHeight(input)] += 1;
    }
}

function getObstaclesHeight(input) {
    return +input.shift();
}

function calculatePrefixSumObstacles(S, J, H) {
    for (let i = H; i > 1; i--) {
        S[i - 1] = S[i] + S[i - 1];
        J[i - 1] = J[i] + J[i - 1];
    }
}

function calculateBrokenObstacleDetails(S, J, H) {
    const result = [];
    for (let i = 1; i <= H; i++) {
        result.push(S[i] + J[H + 1 - i]);
    }
    return result;
}