function solution(a, b) {
    let pSum = 0;
    let max = Math.max(a, b);
    let min = Math.min(a, b);
    
    if(max===min) return max;
    
    for(let i=min; i<=max; i++){
        pSum += i;
    }
    return pSum;
}